package co.grandcircus.VoteAssist.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * The Time Machine allows the application to switch between 
 * wall clock time for normal use and a fixed time for demoing.
 * 
 * TODO: Add a Spring profile to enable/disable this feature. In a 
 * production environment, this feature should be disabled.
 */
@Service
public class TimeMachineService {
	
	Optional<LocalDateTime> fixedTime = Optional.empty();
	
	/**
	 * Enable the Time Machine
	 * 
	 * @param fixedTime The fixed time that will be returned by the time machine.
	 */
	public void enableTimeMachine(LocalDateTime fixedTime) {
		this.fixedTime = Optional.of(fixedTime);
	}
	
	/**
	 * Disable the Time Machine
	 * 
	 * Once disabled, wall clock time will be returned.
	 */
	public void disableTimeMachine() {
		this.fixedTime = Optional.empty();
	}
	
	/**
	 * @return Return the current time machine time or wallclock time if time 
	 * machine time is unavailable.
	 */
	public LocalDateTime getTime() {
		return fixedTime.orElseGet(() -> LocalDateTime.now());
	}
}
