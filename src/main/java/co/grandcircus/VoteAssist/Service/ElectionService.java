package co.grandcircus.VoteAssist.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

/**
 * In this service is the date of the general election.
 */
@Service
public class ElectionService {
	
	private static final LocalDateTime ELECTION_DATE = LocalDateTime.of(2020, 11, 03, 8, 00, 00);
	
	public LocalDateTime getNextElectionDate() {
		return ELECTION_DATE;
	}
}
