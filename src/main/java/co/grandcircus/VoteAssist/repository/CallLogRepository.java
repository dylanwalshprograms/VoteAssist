package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.VoteAssist.entity.CallLog;

public interface CallLogRepository extends JpaRepository<CallLog,Long>{

}
