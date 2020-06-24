package co.grandcircus.VoteAssist.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.grandcircus.VoteAssist.entity.VoterData;

public interface VoterRepository extends JpaRepository<VoterData, Long>{
	
	
	// NOTE: IF THE WHOLE LIST IS DNC, DNC RECORDS WILL PULL???
	@Query(value = "SELECT * FROM vote_assist.voter_data WHERE (in_use = 0 OR in_use IS NULL) AND (do_not_call = 0 OR do_not_call IS NULL) ORDER BY next_call LIMIT 1", nativeQuery = true)
	VoterData findVoterByNextCall();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'WVBM' OR result = 'VIP';", nativeQuery = true)
	double findAllWVBMAndWVIP();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'NV';", nativeQuery = true)
	double findAllNotVoting();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'DNC';", nativeQuery = true)
	double findAllDoNotCall();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE NOT result = 'NA' OR result = 'RQ';", nativeQuery = true)
	double findAllResponsesMinusNAAndRQ();
	
	@Query(value = "SELECT * FROM vote_assist.voter_data WHERE result = 'WVBM' LIMIT 1;", nativeQuery = true)
	VoterData findbyWVBM();
	
	@Query(value = "SELECT * FROM vote_assist.voter_data WHERE result = 'VIP' LIMIT 1;", nativeQuery = true)
	VoterData findbyVIP();
	
	@Query(value = "UPDATE `vote_assist`.`voter_data` SET `result` = 'VIP' WHERE state = :state ;", nativeQuery = true)
	@Modifying
	@Transactional
	void updatePastRegistrationStateVoters(@Param("state") String state);
	
	@Query(value = "UPDATE `vote_assist`.`voter_data` SET `do_not_call` = NULL, `last_call` = NULL, `next_call` = NULL, `result` = NULL, `in_use` = NULL;", nativeQuery = true)
	@Modifying
	@Transactional
	void resetDatabase();

}
