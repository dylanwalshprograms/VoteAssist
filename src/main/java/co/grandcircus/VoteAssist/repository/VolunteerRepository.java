package co.grandcircus.VoteAssist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.VoteAssist.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	
	Optional<Volunteer> findByUserNameAndPassword(String userName, String password);

}
