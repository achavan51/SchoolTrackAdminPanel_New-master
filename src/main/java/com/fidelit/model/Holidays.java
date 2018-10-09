package com.fidelit.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="holidays")

public class Holidays implements Serializable{
	private Integer holidayId;
	private String holidayTitle;
	private java.util.Date holidayDate;
	private String holidayDescription;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="holidayId")
	public Integer getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}
	
	@Column(name="holidayTitle")
	public String getHolidayTitle() {
		return holidayTitle;
	}
	public void setHolidayTitle(String holidayTitle) {
		this.holidayTitle = holidayTitle;
	}
	
	@Column(name="holidayDate")
	public java.util.Date getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(java.util.Date date) {
		this.holidayDate = date;
	}
	
	@Column(name="holidayDescription")
	public String getHolidayDescription() {
		return holidayDescription;
	}
	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}
	
	
}
