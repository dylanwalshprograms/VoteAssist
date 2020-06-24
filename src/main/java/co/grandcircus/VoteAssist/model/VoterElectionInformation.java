package co.grandcircus.VoteAssist.model;

import java.time.LocalDateTime;

import co.grandcircus.VoteAssist.entity.Volunteer;
import co.grandcircus.VoteAssist.entity.VoterData;
import co.grandcircus.VoteAssist.methods.VoteAssistMethods;

public class VoterElectionInformation {

	private LocalDateTime electionDay;
	private LocalDateTime regCutoff;
	private Volunteer currentVolunteer;
	private String campaignName;
	private StateVoteInfoResponse stateResponse;
	private CivicApiResponse civicResponse;
	private VoterData voterData;

	public VoterElectionInformation(LocalDateTime electionDay, LocalDateTime regCutoff, Volunteer currentVolunteer,
			String campaignName, StateVoteInfoResponse stateResponse, CivicApiResponse civicResponse,
			VoterData voterData) {
		super();
		this.electionDay = electionDay;
		this.regCutoff = regCutoff;
		this.currentVolunteer = currentVolunteer;
		this.campaignName = campaignName;
		this.stateResponse = stateResponse;
		this.civicResponse = civicResponse;
		this.voterData = voterData;
	}

	public LocalDateTime getElectionDay() {
		return electionDay;
	}

	public void setElectionDay(LocalDateTime electionDay) {
		this.electionDay = electionDay;
	}

	public LocalDateTime getRegCutoff() {
		return regCutoff;
	}

	public void setRegCutOff(LocalDateTime regCutoff) {
		this.regCutoff = regCutoff;
	}

	public Volunteer getCurrentVolunteer() {
		return currentVolunteer;
	}

	public void setCurrentVolunteer(Volunteer currentVolunteer) {
		this.currentVolunteer = currentVolunteer;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public StateVoteInfoResponse getStateResponse() {
		return stateResponse;
	}

	public void setStateResponse(StateVoteInfoResponse stateResponse) {
		this.stateResponse = stateResponse;
	}

	public CivicApiResponse getCivicResponse() {
		return civicResponse;
	}

	public void setCivicResponse(CivicApiResponse civicResponse) {
		this.civicResponse = civicResponse;
	}

	public VoterData getVoterData() {
		return voterData;
	}

	public void setVoterData(VoterData voterData) {
		this.voterData = voterData;
	}
	
	public String getRegCutoffDateInWords() {
		return VoteAssistMethods.localDateTimeInWords(regCutoff);
	}
	
	public String getElectionDateInWords() {
		return VoteAssistMethods.localDateTimeInWords(electionDay);
	}
	
	public String getLastCallInWords() {
		return VoteAssistMethods.localDateTimeInWords(voterData.getLastCall());
	}
	
	public String getNextCallInWords() {
		return VoteAssistMethods.localDateTimeInWords(voterData.getNextCall());
	}

	@Override
	public String toString() {
		return "VoterElectionInformation [electionDay=" + electionDay + ", regCutoff=" + regCutoff
				+ ", currentVolunteer=" + currentVolunteer + ", campaignName=" + campaignName + ", stateResponse="
				+ stateResponse + ", civicResponse=" + civicResponse + ", voterData=" + voterData + "]";
	}
}
