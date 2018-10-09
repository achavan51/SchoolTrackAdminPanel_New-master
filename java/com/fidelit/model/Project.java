package com.fidelit.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name ="project")
public class Project implements Serializable {

	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private String projectTechnology;
	private java.util.Date projectStartDate;
	private java.util.Date projectEndDate;
	private String projectStatus;
	//sprivate Integer clientId;
	private Clients client;
	private EmployeeProject employeeProject;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="projectId")
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	@Column(name="projectName")
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Column(name="projectDescription")
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	@Column(name="projectTechnology")
	public String getProjectTechnology() {
		return projectTechnology;
	}
	public void setProjectTechnology(String projectTechnology) {
		this.projectTechnology = projectTechnology;
	}
	
	@Column(name="projectStartDate")
	public java.util.Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(java.util.Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	@Column(name="projectEndDate")
	public java.util.Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(java.util.Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	@Column(name="projectStatus")
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	@OneToOne
	@JoinColumn(name="clientId")
	public Clients getClient() {
		return client;
	}
	public void setClient(Clients client) {
		this.client = client;
	}
	
	
	@OneToOne(mappedBy="project" , cascade=CascadeType.ALL)
	public EmployeeProject getEmployeeProject() {
		return employeeProject;
	}
	public void setEmployeeProject(EmployeeProject employeeProject) {
		this.employeeProject = employeeProject;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", projectDescription=" + projectDescription
				+ ", projectTechnology=" + projectTechnology
				+ ", projectStartDate=" + projectStartDate
				+ ", projectEndDate=" + projectEndDate + ", projectStatus="
				+ projectStatus + ", client=" + client + ", employeeProject="
				+ employeeProject + "]";
	}
	
	/*@Column(name="clientId")
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}*/
	
	
}
