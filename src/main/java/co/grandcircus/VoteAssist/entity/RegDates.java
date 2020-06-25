package co.grandcircus.VoteAssist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class RegDates {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@JsonProperty(value = "state_id")
	private String stateId;
	
	@JsonProperty(value = "days_before_election")
	private Integer daysBeforeElection;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public Integer getDaysBeforeElection() {
		return daysBeforeElection;
	}

	public void setDaysBeforeElection(Integer daysBeforeElection) {
		this.daysBeforeElection = daysBeforeElection;
	}

	@Override
	public String toString() {
		return "RegDates [Id=" + Id + ", stateId=" + stateId + ", daysBeforeElection=" + daysBeforeElection + "]";
	}
}
