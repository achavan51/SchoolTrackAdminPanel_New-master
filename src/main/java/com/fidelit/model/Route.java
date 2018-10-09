package com.fidelit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="route")
public class Route implements Serializable{

	 /**
	 * 
	 */
	 private static final long serialVersionUID = 3165354130753674683L;
	 private Integer routeNo;
	 private String  routeName;
	 private Boolean routeStatus;
	 private String  startStop;
	 private String  endStop;
	 private String corridorId;
	 private String accountId;
	 private List<Stop> stopList;
	 private Bus      bus;
	 private BusDriver busDriver;
	 private List<SchoolAdmin> schoolAdmin;
	 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public Integer getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(Integer routeNo) {
		this.routeNo = routeNo;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Boolean getRouteStatus() {
		return routeStatus;
	}
	public void setRouteStatus(Boolean routeStatus) {
		this.routeStatus = routeStatus;
	}
	public String getStartStop() {
		return startStop;
	}
	public void setStartStop(String startStop) {
		this.startStop = startStop;
	}
	public String getEndStop() {
		return endStop;
	}
	public void setEndStop(String endStop) {
		this.endStop = endStop;
	}
	
	@OneToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy="route")
	public List<Stop> getStopList() {
		return stopList;
	}
	public void setStopList(List<Stop> stopList) {
		this.stopList = stopList;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="regNumber")
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="driverName")
	public BusDriver getBusDriver() {
		return busDriver;
	}
	public void setBusDriver(BusDriver busDriver) {
		this.busDriver = busDriver;
	}
	 
	
	public String getCorridorId() {
		return corridorId;
	}
	public void setCorridorId(String corridorId) {
		this.corridorId = corridorId;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="studentId",nullable = true, insertable = true, updatable = true)
	public List<SchoolAdmin> getSchoolAdmin() {
		return schoolAdmin;
	}
	public void setSchoolAdmin(List<SchoolAdmin> schoolAdmin) {
		this.schoolAdmin = schoolAdmin;
	}
	
	
	
}
