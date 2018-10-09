package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Route;
import com.fidelit.model.Stop;

public interface RouteService {

	void updateRoute(Route route);
	void addRoute(Route route);
	List<Route> getRouteList(String accountId);
	Route getRouteId(int id);
	void deleteRoute(int id);
	void deleteBusInRoute(int id);
	int getLastRouteId();
	void deleteDriverInRoute(int driverId);
	List<Route> allRouteList(String userName);
	List<Route> allRouteListDriver(String userName);
}
