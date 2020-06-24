package co.grandcircus.VoteAssist.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class ElectionService {
	
	private static final LocalDateTime ELECTION_DATE = LocalDateTime.of(2020, 11, 03, 8, 00, 00);
	
	public LocalDateTime getNextElectionDate() {
		return ELECTION_DATE;
	}
}
