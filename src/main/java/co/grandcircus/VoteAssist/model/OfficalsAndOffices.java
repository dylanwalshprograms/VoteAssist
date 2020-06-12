package co.grandcircus.VoteAssist.model;

public class OfficalsAndOffices {
	
	private Officials official;
	
	private Offices office;

	public Officials getOfficial() {
		return official;
	}

	public void setOfficial(Officials official) {
		this.official = official;
	}

	public Offices getOffice() {
		return office;
	}

	public void setOffice(Offices office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "OfficalsAndOffices [official=" + official + ", office=" + office + "]";
	}
	
	

}
