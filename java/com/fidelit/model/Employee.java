package com.fidelit.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="employee")
public class Employee implements Serializable{

	private Integer id;
	private String userName;
	private String password;
	private String passwordConfirm;
	private String firstName;
	private String lastName;
	private Date   birthDate;
	private String sex;
	private String maritalStatus;
	private String email;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String country;
	private Integer phone;
	private String designation;
	private UserRole userRole;
	private SuperVisor supervisor;
	private EmployeeProject employeeProject;
	private EmployeeSkill employeeSkill;
	private List<LeavesApplied> leavesApplied;
	private empLeavesTaken empLeavestaken;
	
	public Employee(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="empFirstName")
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="empLastName")
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="empBirthDate")
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="empGender")
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="empMaritalStatus")
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	@Column(name="empEmail")
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	@Column(name="empAddress")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="empCity")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="empState")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="empZip")
	public Integer getZip() {
		return zip;
	}
	
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	@Column(name="empCountry")
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	@Column(name="empMobile")
	public Integer getPhone() {
		return phone;
	}
	
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	@Column(name="empUsername")
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="empPassword")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne(mappedBy="employee" , cascade=CascadeType.ALL)
	public UserRole getUserRole() {
		return userRole;
	}
	
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	@Column(name="empDesignation")
	public String getDesignation() {
		return designation;
	}
	
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@OneToOne(mappedBy="employee" , cascade=CascadeType.ALL)
	public SuperVisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(SuperVisor supervisor) {
		this.supervisor = supervisor;
	}

	@OneToOne(mappedBy="employee" , cascade=CascadeType.ALL)
	public EmployeeProject getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(EmployeeProject employeeProject) {
		this.employeeProject = employeeProject;
	}

	@OneToOne(mappedBy="employee" , cascade=CascadeType.ALL)
	public EmployeeSkill getEmployeeSkill() {
		return employeeSkill;
	}

	public void setEmployeeSkill(EmployeeSkill employeeSkill) {
		this.employeeSkill = employeeSkill;
	}

	 /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JoinColumn(name = "empId", nullable = false)
*/	
	@OneToMany(targetEntity=LeavesApplied.class,  mappedBy="employee" , cascade=CascadeType.ALL)
	public List<LeavesApplied> getLeavesApplied() {
		return leavesApplied;
	}

	public void setLeavesApplied(List<LeavesApplied> leavesApplied) {
		this.leavesApplied = leavesApplied;
	}

	@OneToOne(mappedBy="employee" , cascade=CascadeType.ALL)
	public empLeavesTaken getEmpLeavestaken() {
		return empLeavestaken;
	}

	public void setEmpLeavestaken(empLeavesTaken empLeavestaken) {
		this.empLeavestaken = empLeavestaken;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


}


