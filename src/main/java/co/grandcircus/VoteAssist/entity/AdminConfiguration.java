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
	private Long delayNV;
	private String priority;

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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getDelayNV() {
		return delayNV;
	}

	public void setDelayNV(Long delayNV) {
		this.delayNV = delayNV;
	}

	@Override
	public String toString() {
		return "AdminConfiguration [id=" + id + ", campaignName=" + campaignName + ", campaignPresetName="
				+ campaignPresetName + ", delayNA=" + delayNA + ", delayVIP=" + delayVIP + ", delayWVBM=" + delayWVBM
				+ ", delayAVBM=" + delayAVBM + ", delayNV=" + delayNV + ", priority=" + priority + "]";
	}

}
