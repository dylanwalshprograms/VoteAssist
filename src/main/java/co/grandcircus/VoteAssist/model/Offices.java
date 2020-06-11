package co.grandcircus.VoteAssist.model;

import java.util.List;

public class Offices {

	private String name;
	private String divisionId;
	private List<String> levels;
	private List<String> roles;
	private List<Integer> officialIndices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public List<String> getLevels() {
		return levels;
	}

	public void setLevels(List<String> levels) {
		this.levels = levels;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<Integer> getOfficialIndices() {
		return officialIndices;
	}

	public void setOfficialIndices(List<Integer> officialIndices) {
		this.officialIndices = officialIndices;
	}

	@Override
	public String toString() {
		return "Offices [name=" + name + ", divisionId=" + divisionId + ", levels=" + levels + ", roles=" + roles
				+ ", officialIndices=" + officialIndices + "]";
	}
}
