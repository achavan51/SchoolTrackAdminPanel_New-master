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
@Table(name ="employeeSkill")
public class EmployeeSkill implements Serializable {
	private Integer employeeSkillId;
	private Employee employee;
	private Skill skill;
	private  String experience;
	private Integer rating;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeSkillId")
	public Integer getEmployeeSkillId() {
		return employeeSkillId;
	}
	public void setEmployeeSkillId(Integer employeeSkillId) {
		this.employeeSkillId = employeeSkillId;
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
	@JoinColumn(name="skillId")
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	@Column(name="experience")
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Column(name="rating")
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
