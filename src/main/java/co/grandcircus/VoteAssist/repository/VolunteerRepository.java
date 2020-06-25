package co.grandcircus.VoteAssist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	
	Optional<Volunteer> findByUserNameAndPassword(String userName, String password);
	Volunteer findByUserName(String userName);
	
	@Query(value = "SELECT count(*) FROM vote_assist.volunteer;", nativeQuery = true)
	Integer findAllVolunteers();
	
	Volunteer findByEmail(String email);
}
