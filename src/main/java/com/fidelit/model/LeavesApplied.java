package com.fidelit.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="leavesApplied")
public class LeavesApplied implements Serializable {
	private Integer leavesAppliedId;
	private Employee employee;
	private java.util.Date leaveStart;
	private java.util.Date leaveEnd;
	private Integer workingDays;
	private String leaveStatus;
	private String leaveReason;
	private SuperVisor supervisor;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="leavesAppliedId")
	public Integer getLeavesAppliedId() {
		return leavesAppliedId;
	}
	public void setLeavesAppliedId(Integer leavesAppliedId) {
		this.leavesAppliedId = leavesAppliedId;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="empId")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	@Column(name="leaveStatus")
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	@ManyToOne
	@JoinColumn(name="sId")
	public SuperVisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(SuperVisor supervisor) {
		this.supervisor = supervisor;
	}
	
	@Column(name="leaveStart")
	public java.util.Date getLeaveStart() {
		return leaveStart;
	}
	public void setLeaveStart(java.util.Date leaveStart) {
		this.leaveStart = leaveStart;
	}
	
	@Column(name="leaveEnd")
	public java.util.Date getLeaveEnd() {
		return leaveEnd;
	}
	public void setLeaveEnd(java.util.Date leaveEnd) {
		this.leaveEnd = leaveEnd;
	}
	
	@Column(name="workingDays")
	public Integer getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}
	
	@Column(name="leaveReason")
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	
	
	
}
