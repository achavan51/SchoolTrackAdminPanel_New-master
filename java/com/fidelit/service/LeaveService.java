package com.fidelit.service;

import java.util.List;

import com.fidelit.model.LeavesApplied;


public interface LeaveService {
	List<LeavesApplied> allLeaveList();

	void leaveApproved(Integer id, Integer wDays);

	void leaveAccept(Integer id);

	void leaveReject(Integer id);

	void leaveWithdraw(Integer id, String status);

}
