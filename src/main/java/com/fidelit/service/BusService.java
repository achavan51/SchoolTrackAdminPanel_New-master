package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.Bus;
import com.fidelit.model.Clients;

public interface BusService {

	void addBus(Bus bus);
	void updateBus(Bus bus);
	ArrayList<Bus> getAllBus();
	List<Bus> allBusList(String userName);
	Bus getBusId(int id);
	void deleteBus(int id);
	Bus getBusRegNo(String regNo);
	boolean getUniqueVehicleNo(String userName);
}
