package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.VoterData;

public interface VoterRepository extends JpaRepository<VoterData, Long>{
	
	
	// NOTE: IF THE WHOLE LIST IS DNC, DNC RECORDS WILL PULL???
	@Query(value = "SELECT * FROM vote_assist.voter_data WHERE do_not_call = 0 ORDER BY next_call LIMIT 1", nativeQuery = true)
	VoterData findVoterByNextCall();

}
