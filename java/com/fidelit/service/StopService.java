package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.Stop;

public interface StopService {
	
	void addStop(Stop stop);
	void updateStop(Stop stop);
	//void deleteEmployee(Employee employee);
	ArrayList<Stop> getAllStop();
//	boolean checkUserName(String userName);
	List<Stop> allStopList();
	Stop getStopId(int id);
	Stop getStop(String stopName);
	void deleteStop(int id);
	
}
