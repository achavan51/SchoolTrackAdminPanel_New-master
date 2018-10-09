 package com.fidelit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AppDevices")
public class AddDeviceForNotification {
	

	private Integer ID;
	private String IMEI;
	private String RegistrationNo;
	private String UId;
	private Boolean isAndroid;
	private String TokenId;
	
	public String getUId() {
		return UId;
	}
	public void setUId(String uId) {
		UId = uId;
	}
	public Boolean getIsAndroid() {
		return isAndroid;
	}
	public void setIsAndroid(Boolean isAndroid) {
		this.isAndroid = isAndroid;
	}
	public String getTokenId() {
		return TokenId;
	}
	public void setTokenId(String tokenId) {
		TokenId = tokenId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	
	
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	
	public String getRegistrationNo() {
		return RegistrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		RegistrationNo = registrationNo;
	}
	
}