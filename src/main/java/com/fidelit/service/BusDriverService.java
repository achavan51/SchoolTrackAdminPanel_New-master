package com.fidelit.service;

import java.util.List;

import com.fidelit.model.BusDriver;

public interface BusDriverService {
	
	void addBusDriver(BusDriver busDriver);
	void updateBusDriver(BusDriver busDriver);
	List<BusDriver> allBusDriverList(String userName);
	BusDriver getBusDriverId(int id);
	void deleteBusDriver(int id);
	BusDriver getDriverByName(String driverName);
	BusDriver getDriverById(int id);

}
