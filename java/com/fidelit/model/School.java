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
@Table(name="school")
public class School implements Serializable{


	
	private Integer id;
	 
	private String schoolName;
	
	private String address;
	
	private String details;
	
	private String location;
	
	private String city;
	
	private String accountId;
	
	public School(){
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	@Column(name="schoolName")
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Column(name="details")
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	


	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void addSchool(School school) {
		// TODO Auto-generated method stub
		
	}

	public List<School> allEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}


}


