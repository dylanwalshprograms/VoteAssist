package co.grandcircus.VoteAssist.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class VoterData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String partyPref;
	private Boolean voteByMail;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime nextCall;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime lastCall;
	private String notes;
	private String result;
	private Boolean emailSent;
	private Boolean doNotCall;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPartyPref() {
		return partyPref;
	}

	public void setPartyPref(String partyPref) {
		this.partyPref = partyPref;
	}

	public Boolean getVoteByMail() {
		return voteByMail;
	}

	public void setVoteByMail(Boolean voteByMail) {
		this.voteByMail = voteByMail;
	}

	public LocalDateTime getNextCall() {
		return nextCall;
	}

	public void setNextCall(LocalDateTime nextCall) {
		this.nextCall = nextCall;
	}

	public LocalDateTime getLastCall() {
		return lastCall;
	}

	public void setLastCall(LocalDateTime lastCall) {
		this.lastCall = lastCall;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Boolean getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Boolean emailSent) {
		this.emailSent = emailSent;
	}

	public Boolean getDoNotCall() {
		return doNotCall;
	}

	public void setDoNotCall(Boolean doNotCall) {
		this.doNotCall = doNotCall;
	}

	@Override
	public String toString() {
		return "VoterData [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", partyPref=" + partyPref + ", voteByMail=" + voteByMail
				+ ", nextCall=" + nextCall + ", lastCall=" + lastCall + ", notes=" + notes + ", result=" + result
				+ ", emailSent=" + emailSent + ", doNotCall=" + doNotCall + "]";
	}
}
