package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.AdminConfiguration;

public interface AdminRepository extends JpaRepository<AdminConfiguration, Long> {
	
	
	@Query(value = "SELECT * FROM admin_configuration WHERE id > 0 LIMIT 1", nativeQuery = true)
	AdminConfiguration findByLowestId();

	
}
