package com.fidelit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="busDriver")
public class BusDriver {
	
	Integer driverId;
	String 	driverName;
	String  address;
	String  city;
	String  licenseNo;
	String  experiance;
	Integer age;
	String  accountId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="driverId")
	public Integer getDriverId() {
		return driverId;
	}
	

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	
	@Column(name="driverName")
	public String getDriverName() {
		return driverName;
	}
	
	public void setDriverName(String driverName) {
		this.driverName = driverName;
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
	@Column(name="licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	@Column(name="experiance")
	public String getExperiance() {
		return experiance;
	}
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
	
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name="accountId")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
 
	
	
}
