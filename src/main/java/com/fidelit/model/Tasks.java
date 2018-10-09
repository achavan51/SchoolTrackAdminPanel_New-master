package com.fidelit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tasks")

public class Tasks implements Serializable{
	private Integer taskId;
	private EmployeeProject empProject;
	private String taskTitle;
	private String taskDescription;
	private Float taskHoursRequired;
	private Float taskHoursSpend;
	private String taskStatus;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="taskId")
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	@OneToOne
	@JoinColumn(name="empProjectId")
	public EmployeeProject getEmpProject() {
		return empProject;
	}
	public void setEmpProject(EmployeeProject empProject) {
		this.empProject = empProject;
	}
	
	@Column(name="tasktitle")
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	@Column(name="taskDescription")
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	@Column(name="taskHoursRequired")
	public Float getTaskHoursRequired() {
		return taskHoursRequired;
	}
	public void setTaskHoursRequired(Float taskHoursRequired) {
		this.taskHoursRequired = taskHoursRequired;
	}
	
	@Column(name="taskHoursSpend")
	public Float getTaskHoursSpend() {
		return taskHoursSpend;
	}
	public void setTaskHoursSpend(Float taskHoursSpend) {
		this.taskHoursSpend = taskHoursSpend;
	}
	
	@Column(name="taskStatus")
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	
	
}
