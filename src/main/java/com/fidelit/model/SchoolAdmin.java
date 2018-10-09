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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="schoolAdmin")
public class SchoolAdmin implements Serializable  {
	
	private Integer id;
	
	
	private String name;
	
	private String password;
	
	private String address;
	
	private String email;

	private Integer age;
	
	private String city;
	
	private School school;
	
	private String username;
	
	private String accountType;

	private Boolean enabled;
	
	private String role;
	
	private String accountId;
    
	private Boolean isUsed=false;
	
	private List<Route> route;
    
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Required
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Required
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Required
	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Required
	@Email
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Required
	@Column(name="age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Required
	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Required
	@OneToOne(cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="schoolId",nullable = true, insertable = true, updatable = true)
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Required
	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Required
	@Column(name="accountType")
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Required
	@Column(name="enabled")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Required
	@Column(name="role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="accountId")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Required
	@ManyToMany(cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="routeId",nullable = true, insertable = true, updatable = true)
	public List<Route> getRoute() {
		return route;
	}

	public void setRoute(List<Route> route) {
		this.route = route;
	}

	@Column(name="isUsed")
	public Boolean isUsed() {
		return isUsed;
	}

	public void setUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}



	
	
	
	
}
