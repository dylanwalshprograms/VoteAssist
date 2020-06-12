package co.grandcircus.VoteAssist.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class CallLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime callTime;
	@ManyToOne
	private Volunteer volunteer;
	@ManyToOne
	private VoterData voterData;

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

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	public VoterData getVoterData() {
		return voterData;
	}

	public void setVoterData(VoterData voterData) {
		this.voterData = voterData;
	}

	@Override
	public String toString() {
		return "CallLog [id=" + id + ", callTime=" + callTime + ", volunteer=" + volunteer + ", voterData=" + voterData
				+ "]";
	}
}
