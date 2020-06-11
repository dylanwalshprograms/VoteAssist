package co.grandcircus.VoteAssist.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CallLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime callTime;
	//@ManyToOne
	private Long volunteerId;
	//@ManyToOne
	private Long voterDataId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCallTime() {
		return callTime;
	}

	public void setCallTime(LocalDateTime callTime) {
		this.callTime = callTime;
	}

	public Long getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(Long volunteerId) {
		this.volunteerId = volunteerId;
	}

	public Long getVoterId() {
		return voterDataId;
	}

	public void setVoterId(Long voterId) {
		this.voterDataId = voterId;
	}

	@Override
	public String toString() {
		return "CallLog [id=" + id + ", callTime=" + callTime + ", volunteerId=" + volunteerId + ", voterId=" + voterDataId
				+ "]";
	}
}
