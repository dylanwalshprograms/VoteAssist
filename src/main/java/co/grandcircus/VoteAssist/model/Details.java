package co.grandcircus.VoteAssist.model;

public class Details {

	private String stateId;
	private String voterReg;

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getVoterReg() {
		return voterReg;
	}

	public void setVoterReg(String voterReg) {
		this.voterReg = voterReg;
	}

	@Override
	public String toString() {
		return "Details [stateId=" + stateId + ", voterReg=" + voterReg + "]";
	}
}
