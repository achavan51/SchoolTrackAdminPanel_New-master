package com.fidelit.service;

public interface GtsService {
    void addAccountInGts(String accountId);

	void addCorridorInGts(String accountId, String corridorID,
			String description);
	void addCorridorInGtsList(String accountId, String corridorID,double latitude,double longitude,int stopID);
	
	void editCorridorInGts(String accountId, String corridorID,
			String description);
	
	void deleteCorridor(String corridorID);
	void editCorridorInGtsList(String accountId, String corridorID,double latitude,double longitude,int stopID);
}
