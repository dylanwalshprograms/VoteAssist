package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.VoteAssist.entity.VoterData;

public interface VoterRepository extends JpaRepository<VoterData, Long>{

}
