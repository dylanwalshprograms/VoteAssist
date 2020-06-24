package co.grandcircus.VoteAssist.Service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import co.grandcircus.VoteAssist.entity.RegDates;
import co.grandcircus.VoteAssist.repository.RegDayRepo;
import co.grandcircus.VoteAssist.repository.VoterRepository;

@Service
public class PastRegistrationsService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PastRegistrationsService.class);
	
	@Autowired
	private ElectionService electionService;
	
	@Autowired
	private TimeMachineService timeMachineService;
	
	@Autowired
	private RegDayRepo regDayRepo;
	
	@Autowired
	private VoterRepository voterRepository;
	
	@Scheduled(fixedRate=60000)
	public void updateVotersWithPassedRegistrations() {
		LOGGER.info("Updating Voters with Missed Registration Dates to VIP");
		
		LocalDateTime nextElectionDate = electionService.getNextElectionDate();
		
		for (RegDates regDates : regDayRepo.findAll()) {
			LocalDateTime registrationCutoff =
					nextElectionDate.minusDays(regDates.getDaysBeforeElection());
			
			if (timeMachineService.getTime().isAfter(registrationCutoff)) {
				LOGGER.info("Updating Voters from {} with Missed Registration Dates to VIP", regDates.getStateId());
				voterRepository.updatePastRegistrationStateVoters(regDates.getStateId());
			}
		}
	}
}
