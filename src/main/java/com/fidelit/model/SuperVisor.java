package com.fidelit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="supervisor")
public class SuperVisor implements Serializable {
	private Integer sId;
	private Employee employee;
	private Integer superVisorId;
	private List<LeavesApplied> leavesApplied;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sId")
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	
	@OneToOne
	@JoinColumn(name="empId")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Column(name="superVisorId")
	public Integer getSuperVisorId() {
		return superVisorId;
	}
	public void setSuperVisorId(Integer superVisorId) {
		this.superVisorId = superVisorId;
	}
	
	@OneToMany(targetEntity=LeavesApplied.class,  mappedBy="supervisor" , cascade=CascadeType.ALL)
	public List<LeavesApplied> getLeavesApplied() {
		return leavesApplied;
	}
	public void setLeavesApplied(List<LeavesApplied> leavesApplied) {
		this.leavesApplied = leavesApplied;
	}
	
	
	
}
