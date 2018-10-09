package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Route;
import com.fidelit.model.Stop;

public interface RouteService {

	void updateRoute(Route route);
	void addRoute(Route route);
	List<Route> getRouteList();
	Route getRouteId(int id);
	void deleteRoute(int id);
}
