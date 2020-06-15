package co.grandcircus.VoteAssist.model;

public class StateInfo {

	private Details details;

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "StateInfo [details=" + details + "]";
	}
}
