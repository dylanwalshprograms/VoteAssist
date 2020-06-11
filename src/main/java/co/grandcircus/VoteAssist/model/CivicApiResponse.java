package co.grandcircus.VoteAssist.model;

import java.util.List;

public class CivicApiResponse {

	private NormalizedInput normalizedInput;
	private String kind;
	private List<Offices> offices;
	private List<Officials> officials;

	public NormalizedInput getNormalizedInput() {
		return normalizedInput;
	}

	public void setNormalizedInput(NormalizedInput normalizedInput) {
		this.normalizedInput = normalizedInput;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<Offices> getOffices() {
		return offices;
	}

	public void setOffices(List<Offices> offices) {
		this.offices = offices;
	}

	public List<Officials> getOfficials() {
		return officials;
	}

	public void setOfficials(List<Officials> officials) {
		this.officials = officials;
	}

	@Override
	public String toString() {
		return "CivicApiResponse [kind=" + kind + "]";
	}
}
