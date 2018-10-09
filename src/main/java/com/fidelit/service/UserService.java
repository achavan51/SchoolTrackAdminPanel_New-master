package com.fidelit.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fidelit.model.Employee;
import com.fidelit.model.LeavesApplied;
import com.fidelit.model.empLeavesTaken;

public interface UserService {

	void addLeave(LeavesApplied leaveApplied);
	
	Employee getEmployeeByUsername(String username);
	
	List<empLeavesTaken> allLeaveBalanceList(int id);
	
	public boolean checkDate(String dateList);

	List<LeavesApplied> allLeaveHistoryList(int id);

	//List<empLeavesTaken> allLeaveHistoryList(int id);
	
}
