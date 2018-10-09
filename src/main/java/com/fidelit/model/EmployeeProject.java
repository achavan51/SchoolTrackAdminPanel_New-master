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
@Table(name ="employeeProject")

public class EmployeeProject implements Serializable{
	private Integer empProjectId;
	private Employee employee;
	private Project project;
	private Tasks tasks;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empProjectId")
	public Integer getEmpProjectId() {
		return empProjectId;
	}
	public void setEmpProjectId(Integer empProjectId) {
		this.empProjectId = empProjectId;
	}

	@OneToOne
	@JoinColumn(name="empId")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@OneToOne
	@JoinColumn(name="projectId")
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	@OneToOne(mappedBy="empProject" , cascade=CascadeType.ALL)
	public Tasks getTasks() {
		return tasks;
	}
	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}
	
}
