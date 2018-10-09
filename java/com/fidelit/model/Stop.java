package com.fidelit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stops")
public class Stop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5356281064785616512L;
	private Integer stopId;
	private String stopName;
	private Double latitude;
	private Double longitude;
	private Date   createdTime;
	private Route   route;
	private Integer stopNo;
	
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getStopId() {
		return stopId;
	}
	public void setStopId(Integer stopId) {
		this.stopId = stopId;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "routeId", nullable = false)
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Integer getStopNo() {
		return stopNo;
	}
	public void setStopNo(Integer stopNo) {
		this.stopNo = stopNo;
	}
  
}
