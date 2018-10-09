package com.fidelit.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="empLeaves")

public class empLeaves implements Serializable {
	private Integer leaveId;
	private Integer leaveType;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="leaveId")
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	
	@Column(name="leaveType")
	public Integer getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(Integer leaveType) {
		this.leaveType = leaveType;
	}
	
	
	
	

}
