package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.VoteAssist.entity.AdminConfiguration;

public interface AdminRepository extends JpaRepository<AdminConfiguration, Long> {

	
}
