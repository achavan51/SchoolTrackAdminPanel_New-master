package com.fidelit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;

@Entity
@Table(name="Device")
public class Device implements Serializable{

	private String accountID;
	private String deviceID;
	private String groupID;
	private String equipmentType;
	private String equipmentStatus;
	private String vehicleMake;
	private String vehicleModel;
	private String vehicleID;
	private String licensePlate;
	private Integer licenseExpire;
	private Integer insuranceExpire;
	private String driverID;
	private Integer driverStatus;
    private Double DoubfuelCapacity;
    private Double fuelEconomy;
    private Double fuelRatePerHour;
    private Double fuelCostPerLiter;
    private String fuelTankProfile;
    private Double speedLimitKPH;
    private Double planDistanceKM;
    private Integer installTime;
    private Integer resetTime;
    private Integer expirationTime;
    private String 	uniqueID;
    private String deviceCode;
    private String deviceType;
    private String pushpinID;
    private String displayColor;
    private String serialNumber;
    private String simPhoneNumber;
    private String simID;
    private String smsEmail;
    private String imeiNumber;
    private String dataKey;
	private Integer ignitionIndex;
	private String codeVersion;
	private String featureSet;
	private String ipAddressValid;
	private Integer lastTotalConnectTime;
	private Integer lastDuplexConnectTime;
	private String pendingPingCommand;
	private Integer lastPingTime;
	private Integer totalPingCount;
	private Integer maxPingCount;
	private Integer commandStateMask;
	private Integer expectAck;
	private Integer expectAckCode;
	private String lastAckCommand;
	private Integer lastAckTime;
	private String dcsPropertiesID;
	private Integer dcsConfigMask;
	private String  dcsConfigString;
	private String dcsCommandHost;
	private Integer supportsDMTP;
	private Integer supportedEncodings;
	private Integer unitLimitInterval;
	private Integer maxAllowedEvents;
	private String totalProfileMask;
	private Integer totalMaxConn;
	private Integer totalMaxConnPerMin;
	private String duplexProfileMask;
	private Integer duplexMaxConn;
	private Integer duplexMaxConnPerMin;
	private String lastTcpSessionID;
	private String ipAddressCurrent;
	private Integer remotePortCurrent;
	private Integer listenPortCurrent;
	private Integer lastInputState;
	private Integer lastOutputState;
	private Integer statusCodeState;
	private Double  lastBatteryLevel;
	private Double lastFuelLevel;
	private Double lastFuelTotal;
	private Double lastOilLevel;
	private Double lastValidLatitude;
	private Double lastValidLongitude;
	private Double lastValidHeading;
	private Double lastValidSpeedKPH;
	private Integer lastGPSTimestamp;
	private Integer lastEventTimestamp;
	private String lastCellServingInfo;
	private Double lastDistanceKM;
	private Double lastOdometerKM;
	private Double odometerOffsetKM;
	private Double lastEngineOnHours;
	private Integer lastEngineOnTime;
	private Integer lastEngineOffTime;
	private Double lastEngineHours;
	private Double engineHoursOffset;
	private Double lastIgnitionOnHours;
	private Integer lastIgnitionOnTime;
	private Integer lastIgnitionOffTime;
	private Double lastIgnitionHours;
	private Integer lastStopTime;
	private Integer lastStartTime;
	private Integer lastMalfunctionLamp;
	private String lastFaultCode;
	private Integer isActive;
	private String displayName;
	private String description;
	private String notes;
	private Integer lastUpdateTime;
	private Integer creationTime;
	private Integer allowNotify;
	private Integer lastNotifyTime;
	private Integer lastNotifyCode;
	private String lastNotifyRule;
	private String notifyEmail;
	private String notifySelector;
	private Integer notifyAction;
	private String  notifyDescription;
	private String notifySubject;
	private String notifyText;
	private Integer notifyUseWrapper;
	private Integer notifyPriority;
	private Double parkedLatitude;
	private Double parkedLongitude;
	private Double parkedRadius;
	private Double parkedMaxSpeedKPH;
	private String assignedUserID;
	private String thermalProfile;
	private String hoursOfOperation;
	private String pendingMessage;
	private String pendingMessageACK;
	private String lastEventsPerSecond;
	private Double lastEventsPerSecondMS;
	private Integer maintIntervalKM0;
	private Double maintOdometerKM0;
	private Double maintIntervalKM1;
	private Double maintOdometerKM1;
	private Double maintIntervalHR0;
	private Double maintEngHoursHR0;
	private String maintNotes;
	private String reminderMessage;
	private String reminderInterval;
	private Integer reminderTime;
	private Integer lastServiceTime;
	private Integer nextServiceTime;
	private Integer lastDataPushTime;
	private Integer lastEventCreateMillis;
	private Integer storageExpiration;
	private Integer vehicleYear;
	private String activeCorridor;
	private Boolean isDeviceUsed = false;
	
	@Id
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getEquipmentStatus() {
		return equipmentStatus;
	}
	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Integer getLicenseExpire() {
		return licenseExpire;
	}
	public void setLicenseExpire(Integer licenseExpire) {
		this.licenseExpire = licenseExpire;
	}
	public Integer getInsuranceExpire() {
		return insuranceExpire;
	}
	public void setInsuranceExpire(Integer insuranceExpire) {
		this.insuranceExpire = insuranceExpire;
	}
	public String getDriverID() {
		return driverID;
	}
	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}
	public Integer getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(Integer driverStatus) {
		this.driverStatus = driverStatus;
	}
	public Double getDoubfuelCapacity() {
		return DoubfuelCapacity;
	}
	public void setDoubfuelCapacity(Double doubfuelCapacity) {
		DoubfuelCapacity = doubfuelCapacity;
	}
	public Double getFuelEconomy() {
		return fuelEconomy;
	}
	public void setFuelEconomy(Double fuelEconomy) {
		this.fuelEconomy = fuelEconomy;
	}
	public Double getFuelRatePerHour() {
		return fuelRatePerHour;
	}
	public void setFuelRatePerHour(Double fuelRatePerHour) {
		this.fuelRatePerHour = fuelRatePerHour;
	}
	public Double getFuelCostPerLiter() {
		return fuelCostPerLiter;
	}
	public void setFuelCostPerLiter(Double fuelCostPerLiter) {
		this.fuelCostPerLiter = fuelCostPerLiter;
	}
	public String getFuelTankProfile() {
		return fuelTankProfile;
	}
	public void setFuelTankProfile(String fuelTankProfile) {
		this.fuelTankProfile = fuelTankProfile;
	}
	public Double getSpeedLimitKPH() {
		return speedLimitKPH;
	}
	public void setSpeedLimitKPH(Double speedLimitKPH) {
		this.speedLimitKPH = speedLimitKPH;
	}
	public Double getPlanDistanceKM() {
		return planDistanceKM;
	}
	public void setPlanDistanceKM(Double planDistanceKM) {
		this.planDistanceKM = planDistanceKM;
	}
	public Integer getInstallTime() {
		return installTime;
	}
	public void setInstallTime(Integer installTime) {
		this.installTime = installTime;
	}
	public Integer getResetTime() {
		return resetTime;
	}
	public void setResetTime(Integer resetTime) {
		this.resetTime = resetTime;
	}
	public Integer getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Integer expirationTime) {
		this.expirationTime = expirationTime;
	}
	

	
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getPushpinID() {
		return pushpinID;
	}
	public void setPushpinID(String pushpinID) {
		this.pushpinID = pushpinID;
	}
	public String getDisplayColor() {
		return displayColor;
	}
	public void setDisplayColor(String displayColor) {
		this.displayColor = displayColor;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getSimPhoneNumber() {
		return simPhoneNumber;
	}
	public void setSimPhoneNumber(String simPhoneNumber) {
		this.simPhoneNumber = simPhoneNumber;
	}
	public String getSimID() {
		return simID;
	}
	public void setSimID(String simID) {
		this.simID = simID;
	}
	public String getSmsEmail() {
		return smsEmail;
	}
	public void setSmsEmail(String smsEmail) {
		this.smsEmail = smsEmail;
	}
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getDataKey() {
		return dataKey;
	}
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
	public Integer getIgnitionIndex() {
		return ignitionIndex;
	}
	public void setIgnitionIndex(Integer ignitionIndex) {
		this.ignitionIndex = ignitionIndex;
	}
	public String getCodeVersion() {
		return codeVersion;
	}
	public void setCodeVersion(String codeVersion) {
		this.codeVersion = codeVersion;
	}
	public String getFeatureSet() {
		return featureSet;
	}
	public void setFeatureSet(String featureSet) {
		this.featureSet = featureSet;
	}
	public String getIpAddressValid() {
		return ipAddressValid;
	}
	public void setIpAddressValid(String ipAddressValid) {
		this.ipAddressValid = ipAddressValid;
	}
	public Integer getLastTotalConnectTime() {
		return lastTotalConnectTime;
	}
	public void setLastTotalConnectTime(Integer lastTotalConnectTime) {
		this.lastTotalConnectTime = lastTotalConnectTime;
	}
	public Integer getLastDuplexConnectTime() {
		return lastDuplexConnectTime;
	}
	public void setLastDuplexConnectTime(Integer lastDuplexConnectTime) {
		this.lastDuplexConnectTime = lastDuplexConnectTime;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getPendingPingCommand() {
		return pendingPingCommand;
	}
	public void setPendingPingCommand(String pendingPingCommand) {
		this.pendingPingCommand = pendingPingCommand;
	}
	public Integer getLastPingTime() {
		return lastPingTime;
	}
	public void setLastPingTime(Integer lastPingTime) {
		this.lastPingTime = lastPingTime;
	}
	public Integer getTotalPingCount() {
		return totalPingCount;
	}
	public void setTotalPingCount(Integer totalPingCount) {
		this.totalPingCount = totalPingCount;
	}
	public Integer getMaxPingCount() {
		return maxPingCount;
	}
	public void setMaxPingCount(Integer maxPingCount) {
		this.maxPingCount = maxPingCount;
	}
	public Integer getCommandStateMask() {
		return commandStateMask;
	}
	public void setCommandStateMask(Integer commandStateMask) {
		this.commandStateMask = commandStateMask;
	}
	public Integer getExpectAck() {
		return expectAck;
	}
	public void setExpectAck(Integer expectAck) {
		this.expectAck = expectAck;
	}
	public Integer getExpectAckCode() {
		return expectAckCode;
	}
	public void setExpectAckCode(Integer expectAckCode) {
		this.expectAckCode = expectAckCode;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getLastAckCommand() {
		return lastAckCommand;
	}
	public void setLastAckCommand(String lastAckCommand) {
		this.lastAckCommand = lastAckCommand;
	}
	public Integer getLastAckTime() {
		return lastAckTime;
	}
	public void setLastAckTime(Integer lastAckTime) {
		this.lastAckTime = lastAckTime;
	}
	public String getDcsPropertiesID() {
		return dcsPropertiesID;
	}
	public void setDcsPropertiesID(String dcsPropertiesID) {
		this.dcsPropertiesID = dcsPropertiesID;
	}
	public Integer getDcsConfigMask() {
		return dcsConfigMask;
	}
	public void setDcsConfigMask(Integer dcsConfigMask) {
		this.dcsConfigMask = dcsConfigMask;
	}
	public String getDcsConfigString() {
		return dcsConfigString;
	}
	public void setDcsConfigString(String dcsConfigString) {
		this.dcsConfigString = dcsConfigString;
	}
	public String getDcsCommandHost() {
		return dcsCommandHost;
	}
	public void setDcsCommandHost(String dcsCommandHost) {
		this.dcsCommandHost = dcsCommandHost;
	}
	public Integer getSupportsDMTP() {
		return supportsDMTP;
	}
	public void setSupportsDMTP(Integer supportsDMTP) {
		this.supportsDMTP = supportsDMTP;
	}
	public Integer getSupportedEncodings() {
		return supportedEncodings;
	}
	public void setSupportedEncodings(Integer supportedEncodings) {
		this.supportedEncodings = supportedEncodings;
	}
	public Integer getUnitLimitInterval() {
		return unitLimitInterval;
	}
	public void setUnitLimitInterval(Integer unitLimitInterval) {
		this.unitLimitInterval = unitLimitInterval;
	}
	public Integer getMaxAllowedEvents() {
		return maxAllowedEvents;
	}
	public void setMaxAllowedEvents(Integer maxAllowedEvents) {
		this.maxAllowedEvents = maxAllowedEvents;
	}

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	public String getTotalProfileMask() {
		return totalProfileMask;
	}
	public void setTotalProfileMask(String totalProfileMask) {
		this.totalProfileMask = totalProfileMask;
	}
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	public String getDuplexProfileMask() {
		return duplexProfileMask;
	}
	public void setDuplexProfileMask(String duplexProfileMask) {
		this.duplexProfileMask = duplexProfileMask;
	}
	public Integer getTotalMaxConn() {
		return totalMaxConn;
	}
	public void setTotalMaxConn(Integer totalMaxConn) {
		this.totalMaxConn = totalMaxConn;
	}
	public Integer getTotalMaxConnPerMin() {
		return totalMaxConnPerMin;
	}
	public void setTotalMaxConnPerMin(Integer totalMaxConnPerMin) {
		this.totalMaxConnPerMin = totalMaxConnPerMin;
	}
	
	public Integer getDuplexMaxConn() {
		return duplexMaxConn;
	}
	public void setDuplexMaxConn(Integer duplexMaxConn) {
		this.duplexMaxConn = duplexMaxConn;
	}
	public Integer getDuplexMaxConnPerMin() {
		return duplexMaxConnPerMin;
	}
	public void setDuplexMaxConnPerMin(Integer duplexMaxConnPerMin) {
		this.duplexMaxConnPerMin = duplexMaxConnPerMin;
	}
	public String getLastTcpSessionID() {
		return lastTcpSessionID;
	}
	public void setLastTcpSessionID(String lastTcpSessionID) {
		this.lastTcpSessionID = lastTcpSessionID;
	}
	public String getIpAddressCurrent() {
		return ipAddressCurrent;
	}
	public void setIpAddressCurrent(String ipAddressCurrent) {
		this.ipAddressCurrent = ipAddressCurrent;
	}
	public Integer getRemotePortCurrent() {
		return remotePortCurrent;
	}
	public void setRemotePortCurrent(Integer remotePortCurrent) {
		this.remotePortCurrent = remotePortCurrent;
	}
	public Integer getListenPortCurrent() {
		return listenPortCurrent;
	}
	public void setListenPortCurrent(Integer listenPortCurrent) {
		this.listenPortCurrent = listenPortCurrent;
	}
	public Integer getLastInputState() {
		return lastInputState;
	}
	public void setLastInputState(Integer lastInputState) {
		this.lastInputState = lastInputState;
	}
	public Integer getLastOutputState() {
		return lastOutputState;
	}
	public void setLastOutputState(Integer lastOutputState) {
		this.lastOutputState = lastOutputState;
	}
	public Integer getStatusCodeState() {
		return statusCodeState;
	}
	public void setStatusCodeState(Integer statusCodeState) {
		this.statusCodeState = statusCodeState;
	}
	public Double getLastBatteryLevel() {
		return lastBatteryLevel;
	}
	public void setLastBatteryLevel(Double lastBatteryLevel) {
		this.lastBatteryLevel = lastBatteryLevel;
	}
	public Double getLastFuelLevel() {
		return lastFuelLevel;
	}
	public void setLastFuelLevel(Double lastFuelLevel) {
		this.lastFuelLevel = lastFuelLevel;
	}
	public Double getLastFuelTotal() {
		return lastFuelTotal;
	}
	public void setLastFuelTotal(Double lastFuelTotal) {
		this.lastFuelTotal = lastFuelTotal;
	}
	public Double getLastOilLevel() {
		return lastOilLevel;
	}
	public void setLastOilLevel(Double lastOilLevel) {
		this.lastOilLevel = lastOilLevel;
	}
	public Double getLastValidLatitude() {
		return lastValidLatitude;
	}
	public void setLastValidLatitude(Double lastValidLatitude) {
		this.lastValidLatitude = lastValidLatitude;
	}
	public Double getLastValidLongitude() {
		return lastValidLongitude;
	}
	public void setLastValidLongitude(Double lastValidLongitude) {
		this.lastValidLongitude = lastValidLongitude;
	}
	public Double getLastValidHeading() {
		return lastValidHeading;
	}
	public void setLastValidHeading(Double lastValidHeading) {
		this.lastValidHeading = lastValidHeading;
	}
	public Double getLastValidSpeedKPH() {
		return lastValidSpeedKPH;
	}
	public void setLastValidSpeedKPH(Double lastValidSpeedKPH) {
		this.lastValidSpeedKPH = lastValidSpeedKPH;
	}
	public Integer getLastGPSTimestamp() {
		return lastGPSTimestamp;
	}
	public void setLastGPSTimestamp(Integer lastGPSTimestamp) {
		this.lastGPSTimestamp = lastGPSTimestamp;
	}
	public Integer getLastEventTimestamp() {
		return lastEventTimestamp;
	}
	public void setLastEventTimestamp(Integer lastEventTimestamp) {
		this.lastEventTimestamp = lastEventTimestamp;
	}
	public String getLastCellServingInfo() {
		return lastCellServingInfo;
	}
	public void setLastCellServingInfo(String lastCellServingInfo) {
		this.lastCellServingInfo = lastCellServingInfo;
	}
	public Double getLastDistanceKM() {
		return lastDistanceKM;
	}
	public void setLastDistanceKM(Double lastDistanceKM) {
		this.lastDistanceKM = lastDistanceKM;
	}
	public Double getLastOdometerKM() {
		return lastOdometerKM;
	}
	public void setLastOdometerKM(Double lastOdometerKM) {
		this.lastOdometerKM = lastOdometerKM;
	}
	public Double getOdometerOffsetKM() {
		return odometerOffsetKM;
	}
	public void setOdometerOffsetKM(Double odometerOffsetKM) {
		this.odometerOffsetKM = odometerOffsetKM;
	}
	public Double getLastEngineOnHours() {
		return lastEngineOnHours;
	}
	public void setLastEngineOnHours(Double lastEngineOnHours) {
		this.lastEngineOnHours = lastEngineOnHours;
	}
	public Integer getLastEngineOnTime() {
		return lastEngineOnTime;
	}
	public void setLastEngineOnTime(Integer lastEngineOnTime) {
		this.lastEngineOnTime = lastEngineOnTime;
	}
	public Integer getLastEngineOffTime() {
		return lastEngineOffTime;
	}
	public void setLastEngineOffTime(Integer lastEngineOffTime) {
		this.lastEngineOffTime = lastEngineOffTime;
	}
	public Double getLastEngineHours() {
		return lastEngineHours;
	}
	public void setLastEngineHours(Double lastEngineHours) {
		this.lastEngineHours = lastEngineHours;
	}
	public Double getEngineHoursOffset() {
		return engineHoursOffset;
	}
	public void setEngineHoursOffset(Double engineHoursOffset) {
		this.engineHoursOffset = engineHoursOffset;
	}
	public Double getLastIgnitionOnHours() {
		return lastIgnitionOnHours;
	}
	public void setLastIgnitionOnHours(Double lastIgnitionOnHours) {
		this.lastIgnitionOnHours = lastIgnitionOnHours;
	}
	public Integer getLastIgnitionOnTime() {
		return lastIgnitionOnTime;
	}
	public void setLastIgnitionOnTime(Integer lastIgnitionOnTime) {
		this.lastIgnitionOnTime = lastIgnitionOnTime;
	}
	public Integer getLastIgnitionOffTime() {
		return lastIgnitionOffTime;
	}
	public void setLastIgnitionOffTime(Integer lastIgnitionOffTime) {
		this.lastIgnitionOffTime = lastIgnitionOffTime;
	}
	public Double getLastIgnitionHours() {
		return lastIgnitionHours;
	}
	public void setLastIgnitionHours(Double lastIgnitionHours) {
		this.lastIgnitionHours = lastIgnitionHours;
	}
	public Integer getLastStopTime() {
		return lastStopTime;
	}
	public void setLastStopTime(Integer lastStopTime) {
		this.lastStopTime = lastStopTime;
	}
	public Integer getLastStartTime() {
		return lastStartTime;
	}
	public void setLastStartTime(Integer lastStartTime) {
		this.lastStartTime = lastStartTime;
	}
	public Integer getLastMalfunctionLamp() {
		return lastMalfunctionLamp;
	}
	public void setLastMalfunctionLamp(Integer lastMalfunctionLamp) {
		this.lastMalfunctionLamp = lastMalfunctionLamp;
	}
	public String getLastFaultCode() {
		return lastFaultCode;
	}
	public void setLastFaultCode(String lastFaultCode) {
		this.lastFaultCode = lastFaultCode;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Integer lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Integer creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getAllowNotify() {
		return allowNotify;
	}
	public void setAllowNotify(Integer allowNotify) {
		this.allowNotify = allowNotify;
	}
	public Integer getLastNotifyTime() {
		return lastNotifyTime;
	}
	public void setLastNotifyTime(Integer lastNotifyTime) {
		this.lastNotifyTime = lastNotifyTime;
	}
	public Integer getLastNotifyCode() {
		return lastNotifyCode;
	}
	public void setLastNotifyCode(Integer lastNotifyCode) {
		this.lastNotifyCode = lastNotifyCode;
	}
	public String getLastNotifyRule() {
		return lastNotifyRule;
	}
	public void setLastNotifyRule(String lastNotifyRule) {
		this.lastNotifyRule = lastNotifyRule;
	}
	public String getNotifyEmail() {
		return notifyEmail;
	}
	public void setNotifyEmail(String notifyEmail) {
		this.notifyEmail = notifyEmail;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getNotifySelector() {
		return notifySelector;
	}
	public void setNotifySelector(String notifySelector) {
		this.notifySelector = notifySelector;
	}
	public Integer getNotifyAction() {
		return notifyAction;
	}
	public void setNotifyAction(Integer notifyAction) {
		this.notifyAction = notifyAction;
	}
	public String getNotifyDescription() {
		return notifyDescription;
	}
	public void setNotifyDescription(String notifyDescription) {
		this.notifyDescription = notifyDescription;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getNotifySubject() {
		return notifySubject;
	}
	public void setNotifySubject(String notifySubject) {
		this.notifySubject = notifySubject;
	}
	
	@Column(columnDefinition="LONGTEXT")
	public String getNotifyText() {
		return notifyText;
	}
	public void setNotifyText(String notifyText) {
		this.notifyText = notifyText;
	}
	public Integer getNotifyUseWrapper() {
		return notifyUseWrapper;
	}
	public void setNotifyUseWrapper(Integer notifyUseWrapper) {
		this.notifyUseWrapper = notifyUseWrapper;
	}
	public Integer getNotifyPriority() {
		return notifyPriority;
	}
	public void setNotifyPriority(Integer notifyPriority) {
		this.notifyPriority = notifyPriority;
	}
	public Double getParkedLatitude() {
		return parkedLatitude;
	}
	public void setParkedLatitude(Double parkedLatitude) {
		this.parkedLatitude = parkedLatitude;
	}
	public Double getParkedLongitude() {
		return parkedLongitude;
	}
	public void setParkedLongitude(Double parkedLongitude) {
		this.parkedLongitude = parkedLongitude;
	}
	public Double getParkedRadius() {
		return parkedRadius;
	}
	public void setParkedRadius(Double parkedRadius) {
		this.parkedRadius = parkedRadius;
	}
	public Double getParkedMaxSpeedKPH() {
		return parkedMaxSpeedKPH;
	}
	public void setParkedMaxSpeedKPH(Double parkedMaxSpeedKPH) {
		this.parkedMaxSpeedKPH = parkedMaxSpeedKPH;
	}
	public String getAssignedUserID() {
		return assignedUserID;
	}
	public void setAssignedUserID(String assignedUserID) {
		this.assignedUserID = assignedUserID;
	}
	public String getThermalProfile() {
		return thermalProfile;
	}
	public void setThermalProfile(String thermalProfile) {
		this.thermalProfile = thermalProfile;
	}
	public String getHoursOfOperation() {
		return hoursOfOperation;
	}
	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}
	public String getPendingMessage() {
		return pendingMessage;
	}
	public void setPendingMessage(String pendingMessage) {
		this.pendingMessage = pendingMessage;
	}
	public String getPendingMessageACK() {
		return pendingMessageACK;
	}
	public void setPendingMessageACK(String pendingMessageACK) {
		this.pendingMessageACK = pendingMessageACK;
	}
	public String getLastEventsPerSecond() {
		return lastEventsPerSecond;
	}
	public void setLastEventsPerSecond(String lastEventsPerSecond) {
		this.lastEventsPerSecond = lastEventsPerSecond;
	}
	public Double getLastEventsPerSecondMS() {
		return lastEventsPerSecondMS;
	}
	public void setLastEventsPerSecondMS(Double lastEventsPerSecondMS) {
		this.lastEventsPerSecondMS = lastEventsPerSecondMS;
	}
	public Integer getMaintIntervalKM0() {
		return maintIntervalKM0;
	}
	public void setMaintIntervalKM0(Integer maintIntervalKM0) {
		this.maintIntervalKM0 = maintIntervalKM0;
	}
	public Double getMaintOdometerKM0() {
		return maintOdometerKM0;
	}
	public void setMaintOdometerKM0(Double maintOdometerKM0) {
		this.maintOdometerKM0 = maintOdometerKM0;
	}
	public Double getMaintIntervalKM1() {
		return maintIntervalKM1;
	}
	public void setMaintIntervalKM1(Double maintIntervalKM1) {
		this.maintIntervalKM1 = maintIntervalKM1;
	}
	public Double getMaintOdometerKM1() {
		return maintOdometerKM1;
	}
	public void setMaintOdometerKM1(Double maintOdometerKM1) {
		this.maintOdometerKM1 = maintOdometerKM1;
	}
	public Double getMaintIntervalHR0() {
		return maintIntervalHR0;
	}
	public void setMaintIntervalHR0(Double maintIntervalHR0) {
		this.maintIntervalHR0 = maintIntervalHR0;
	}
	public Double getMaintEngHoursHR0() {
		return maintEngHoursHR0;
	}
	public void setMaintEngHoursHR0(Double maintEngHoursHR0) {
		this.maintEngHoursHR0 = maintEngHoursHR0;
	}
	public String getMaintNotes() {
		return maintNotes;
	}
	public void setMaintNotes(String maintNotes) {
		this.maintNotes = maintNotes;
	}
	public String getReminderMessage() {
		return reminderMessage;
	}
	public void setReminderMessage(String reminderMessage) {
		this.reminderMessage = reminderMessage;
	}
	public String getReminderInterval() {
		return reminderInterval;
	}
	public void setReminderInterval(String reminderInterval) {
		this.reminderInterval = reminderInterval;
	}
	public Integer getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(Integer reminderTime) {
		this.reminderTime = reminderTime;
	}
	public Integer getLastServiceTime() {
		return lastServiceTime;
	}
	public void setLastServiceTime(Integer lastServiceTime) {
		this.lastServiceTime = lastServiceTime;
	}
	public Integer getNextServiceTime() {
		return nextServiceTime;
	}
	public void setNextServiceTime(Integer nextServiceTime) {
		this.nextServiceTime = nextServiceTime;
	}
	public Integer getLastDataPushTime() {
		return lastDataPushTime;
	}
	public void setLastDataPushTime(Integer lastDataPushTime) {
		this.lastDataPushTime = lastDataPushTime;
	}
	public Integer getLastEventCreateMillis() {
		return lastEventCreateMillis;
	}
	public void setLastEventCreateMillis(Integer lastEventCreateMillis) {
		this.lastEventCreateMillis = lastEventCreateMillis;
	}
	public Integer getStorageExpiration() {
		return storageExpiration;
	}
	public void setStorageExpiration(Integer storageExpiration) {
		this.storageExpiration = storageExpiration;
	}
	public Integer getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(Integer vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	public String getActiveCorridor() {
		return activeCorridor;
	}
	public void setActiveCorridor(String activeCorridor) {
		this.activeCorridor = activeCorridor;
	}
	public Boolean getIsDeviceUsed() {
		return isDeviceUsed;
	}
	public void setIsDeviceUsed(Boolean isDeviceUsed) {
		this.isDeviceUsed = isDeviceUsed;
	}
	
	
}
