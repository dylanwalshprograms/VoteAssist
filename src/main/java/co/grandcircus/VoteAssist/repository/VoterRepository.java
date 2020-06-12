package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.VoterData;

public interface VoterRepository extends JpaRepository<VoterData, Long>{
	
	@Query(value = "SELECT * FROM vote_assist.voter_data ORDER BY next_call LIMIT 1", nativeQuery = true)
	VoterData findVoterByNextCall();

}
