package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.VoterData;

public interface VoterRepository extends JpaRepository<VoterData, Long>{
	
	
	// NOTE: IF THE WHOLE LIST IS DNC, DNC RECORDS WILL PULL???
	@Query(value = "SELECT * FROM vote_assist.voter_data WHERE do_not_call = 0 OR do_not_call IS NULL ORDER BY next_call LIMIT 1", nativeQuery = true)
	VoterData findVoterByNextCall();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'WVBM' OR result = 'VIP';", nativeQuery = true)
	double findAllWVBMAndWVIP();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'NV';", nativeQuery = true)
	double findAllNotVoting();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE result = 'DNC';", nativeQuery = true)
	double findAllDoNotCall();
	
	@Query(value = "SELECT count(*) FROM vote_assist.voter_data WHERE NOT result = 'NA' OR result = 'RQ';", nativeQuery = true)
	double findAllResponsesMinusNAAndRQ();

}
