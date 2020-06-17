package co.grandcircus.VoteAssist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String campaignName;
	private String campaignPresetName;
	private Long delayNA;
	private Long delayVIP;
	private Long delayWVBM;
	private Long delayAVBM;
	private Boolean prioritizeSTD;
	private Boolean prioritizeWVBM;
	private Boolean prioritizeWVIP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignPresetName() {
		return campaignPresetName;
	}

	public void setCampaignPresetName(String campaignPresetName) {
		this.campaignPresetName = campaignPresetName;
	}

	public Long getDelayNA() {
		return delayNA;
	}

	public void setDelayNA(Long delayNA) {
		this.delayNA = delayNA;
	}

	public Long getDelayVIP() {
		return delayVIP;
	}

	public void setDelayVIP(Long delayVIP) {
		this.delayVIP = delayVIP;
	}

	public Long getDelayWVBM() {
		return delayWVBM;
	}

	public void setDelayWVBM(Long delayWVBM) {
		this.delayWVBM = delayWVBM;
	}

	public Long getDelayAVBM() {
		return delayAVBM;
	}

	public void setDelayAVBM(Long delayAVBM) {
		this.delayAVBM = delayAVBM;
	}

	public Boolean getPrioritizeSTD() {
		return prioritizeSTD;
	}

	public void setPrioritizeSTD(Boolean prioritizeSTD) {
		this.prioritizeSTD = prioritizeSTD;
	}

	public Boolean getPrioritizeWVBM() {
		return prioritizeWVBM;
	}

	public void setPrioritizeWVBM(Boolean prioritizeWVBM) {
		this.prioritizeWVBM = prioritizeWVBM;
	}

	public Boolean getPrioritizeWVIP() {
		return prioritizeWVIP;
	}

	public void setPrioritizeWVIP(Boolean prioritizeWVIP) {
		this.prioritizeWVIP = prioritizeWVIP;
	}

	@Override
	public String toString() {
		return "AdminConfiguration [id=" + id + ", campaignName=" + campaignName + ", campaignPresetName="
				+ campaignPresetName + ", delayNA=" + delayNA + ", delayVIP=" + delayVIP + ", delayWVBM=" + delayWVBM
				+ ", delayAVBM=" + delayAVBM + ", prioritizeSTD=" + prioritizeSTD + ", prioritizeWVBM=" + prioritizeWVBM
				+ ", prioritizeWVIP=" + prioritizeWVIP + "]";
	}

}
