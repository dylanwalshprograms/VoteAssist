package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.VoteAssist.entity.RegDates;

public interface RegDayRepo extends JpaRepository <RegDates, Long> {
	
	RegDates findByStateId(String name);
}
