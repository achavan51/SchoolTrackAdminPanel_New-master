package com.fidelit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.fidelit.model.Clients;

public interface ClientService {

	void addClient(Clients client);
	void updateClient(Clients client);
	//void deleteEmployee(Employee employee);
	ArrayList<Clients> getAllClient();
	boolean checkClientId(int clientId);
	List<Clients> allClientList();
	Clients getClientId(int id);
	void deleteClient(int id);
	boolean checkClientUsername(String userName);
}
