package com.smartclean.smartclean.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@Table(name = "tbl_counter")
public class CounterEntity {
	@Column(name = "start_value")
	private int startValue;

	@Column(name = "step_time")
	private int stepTime;

	@Id
	@Column(name = "unique_id")
	private String uniqueId;

	@Column(name = "status")
	private String status;

	@Column(name = "counter_value")
	private int counterValue;

	@Column(name = "creation_time")
    @CreationTimestamp
    private LocalDateTime creationTime;

	@Column(name = "modified_time")
    @LastModifiedBy
    private LocalDateTime modifiedTime;

	public int getStartValue() {
		return startValue;
	}

	public void setStartValue(int startValue) {
		this.startValue = startValue;
	}

	public int getStepTime() {
		return stepTime;
	}

	public void setStepTime(int stepTime) {
		this.stepTime = stepTime;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCounterValue() {
		return counterValue;
	}

	public void setCounterValue(int counterValue) {
		this.counterValue = counterValue;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "CounterEntity [startValue=" + startValue + ", stepTime=" + stepTime + ", uniqueId=" + uniqueId
				+ ", status=" + status + ", counterValue=" + counterValue + ", creationTime=" + creationTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}
}
