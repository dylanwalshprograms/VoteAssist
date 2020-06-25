package co.grandcircus.VoteAssist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.CallLog;

public interface CallLogRepository extends JpaRepository<CallLog,Long>{
	
	@Query(value = "SELECT count(*) FROM vote_assist.call_log;", nativeQuery = true)
	int findAllCallsMade();
	
	List<CallLog> findByResultContainingIgnoreCase(String keyword);
	
	List<CallLog> findByVoterDataId(Long id);
}
