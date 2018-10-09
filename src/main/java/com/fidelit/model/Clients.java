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
import javax.persistence.Transient;

@Entity
@Table(name ="clients")
public class Clients implements Serializable {
	private Integer clientId;
	private String clientName;
	private String clientEmail;
	private Integer clientMobile;
	private String clientAddress;
	private String clientCountry;
	private String clientTimeZone;
	private String skypeId;
	private String clientUsername;
	private String clientPassword;
	private String clientPasswordConfirm;
	private Project project;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="clientId")
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	@Column(name="clientName")
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	@Column(name="clientEmail")
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	@Column(name="clientMobile")
	public Integer getClientMobile() {
		return clientMobile;
	}
	public void setClientMobile(Integer clientMobile) {
		this.clientMobile = clientMobile;
	}
	
	@Column(name="clientAddress")
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	
	@Column(name="clientCountry")
	public String getClientCountry() {
		return clientCountry;
	}
	public void setClientCountry(String clientCountry) {
		this.clientCountry = clientCountry;
	}
	
	@Column(name="clientTimeZone")
	public String getClientTimeZone() {
		return clientTimeZone;
	}
	public void setClientTimeZone(String clientTimeZone) {
		this.clientTimeZone = clientTimeZone;
	}
	
	@Column(name="skypeId")
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	
	@OneToOne(mappedBy="client" , cascade=CascadeType.ALL)
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Column(name="clientUsername")
	public String getClientUsername() {
		return clientUsername;
	}
	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}
	
	@Column(name="clientPassword")
	public String getClientPassword() {
		return clientPassword;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	
	@Transient
	public String getClientPasswordConfirm() {
		return clientPasswordConfirm;
	}
	public void setClientPasswordConfirm(String clientPasswordConfirm) {
		this.clientPasswordConfirm = clientPasswordConfirm;
	}
	
	
}
