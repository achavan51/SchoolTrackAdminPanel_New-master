package com.fidelit.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="empLeavesTaken")
public class empLeavesTaken implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer eLevaesTakenId;
	private Employee employee;
	private Integer leaveCount;
	private Integer leaveBalance;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eLevaesTakenId")
	public Integer geteLevaesTakenId() {
		return eLevaesTakenId;
	}

	public void seteLevaesTakenId(Integer eLevaesTakenId) {
		this.eLevaesTakenId = eLevaesTakenId;
	}

	
	@OneToOne
	@JoinColumn(name="empId")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	@Column(name="leaveCount")
	public Integer getLeaveCount() {
		return leaveCount;
	}
	public void setLeaveCount(Integer leaveCount) {
		this.leaveCount = leaveCount;
	}

	@Column(name="leaveBalance")
	public Integer getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(Integer leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	@Override
	public String toString() {
		return "empLeavesTaken [eLevaesTakenId=" + eLevaesTakenId
				+ ", employee=" + employee + ", leaveCount=" + leaveCount
				+ ", leaveBalance=" + leaveBalance + "]";
	}

	
}
