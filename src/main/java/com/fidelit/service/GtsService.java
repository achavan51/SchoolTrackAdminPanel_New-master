package com.fidelit.service;

import com.fidelit.model.Device;

public interface GtsService {
    void addAccountInGts(String accountId, String password, String discription);

	void addCorridorInGts(String accountId, String corridorID,
			String description);
	void addCorridorInGtsList(String accountId, String corridorID,double latitude,double longitude,int stopID);
	
	void editCorridorInGts(String accountId, String corridorID,
			String description);
	
	void deleteCorridor(String corridorID);
	void editCorridorInGtsList(String accountId, String corridorID,double latitude,double longitude,int stopID);

	void addDeviceInGts(Device device);

	void updateDeviceInGts(Device device);

	void deleteDeviceByUniqueIdAndAccountIdInGts(String uniqueId,
			String userName);

	void deleteDeviceInGts(String accountID);
	
	void deleteAccountInGts(String accountId);

	void editAccountInGts(String accountId, String password, String description);
}
