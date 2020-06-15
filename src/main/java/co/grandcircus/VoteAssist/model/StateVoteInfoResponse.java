package co.grandcircus.VoteAssist.model;

public class StateVoteInfoResponse {

	private StateInfo state;

	public StateInfo getState() {
		return state;
	}

	public void setState(StateInfo state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "StateVoteInfoResponse [state=" + state + "]";
	}
}
