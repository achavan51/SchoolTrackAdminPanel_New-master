package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import com.fidelit.model.Employee;
import com.fidelit.model.Holidays;

public interface HolidayService {
	
	void addHoliday(Holidays holiday);
	void updateHoliday(Holidays holiday);
	//void deleteEmployee(Employee employee);
	ArrayList<Holidays> getAllHoliday();
	//boolean checkUserName(String userName);
	List<Holidays> allHolidayList();
	//Employee getEmployeeyId(int id);
	void deleteHoliday(int id);
	//Holidays getProjectId(Integer id);
	Holidays getHolidayId(Integer id);
	List<Holidays> getHolidayDate();

}
