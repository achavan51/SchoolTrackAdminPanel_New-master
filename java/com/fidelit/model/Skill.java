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
@Table(name ="skill")

public class Skill implements Serializable{
	
	private Integer skillId;
	private String skillName;
	private EmployeeSkill employeeSkill;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="skillId")
	public Integer getSkillId() {
		return skillId;
	}
	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}
	
	@Column(name="skillName")
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	@OneToOne(mappedBy="skill" , cascade=CascadeType.ALL)
	public EmployeeSkill getEmployeeSkill() {
		return employeeSkill;
	}
	public void setEmployeeSkill(EmployeeSkill employeeSkill) {
		this.employeeSkill = employeeSkill;
	}


}
