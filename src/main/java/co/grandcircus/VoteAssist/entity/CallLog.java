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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime nextCall;
	@ManyToOne
	private Volunteer volunteer;
	@ManyToOne
	private VoterData voterData;
	private String result;
	private String notes;
	private boolean doNotCall;

	public CallLog() {
		super();
	}

	public CallLog(LocalDateTime callTime, Volunteer volunteer, VoterData voterData) {
		super();
		this.callTime = callTime;
		this.volunteer = volunteer;
		this.voterData = voterData;
	}
	

	public CallLog(LocalDateTime callTime, LocalDateTime nextCall, Volunteer volunteer, VoterData voterData,
			String result, String notes) {
		super();
		this.callTime = callTime;
		this.nextCall = nextCall;
		this.volunteer = volunteer;
		this.voterData = voterData;
		this.result = result;
		this.notes = notes;
	}

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

	public LocalDateTime getNextCall() {
		return nextCall;
	}

	public void setNextCall(LocalDateTime nextCall) {
		this.nextCall = nextCall;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isDoNotCall() {
		return doNotCall;
	}

	public void setDoNotCall(boolean doNotCall) {
		this.doNotCall = doNotCall;
	}

	@Override
	public String toString() {
		return "CallLog [id=" + id + ", callTime=" + callTime + ", nextCall=" + nextCall + ", volunteer=" + volunteer
				+ ", voterData=" + voterData + ", result=" + result + ", notes=" + notes + ", doNotCall=" + doNotCall
				+ "]";
	}

}
