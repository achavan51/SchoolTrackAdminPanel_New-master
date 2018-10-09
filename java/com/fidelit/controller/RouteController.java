package com.fidelit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fidelit.model.Bus;
import com.fidelit.model.BusDriver;
import com.fidelit.model.Route;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.Stop;
import com.fidelit.service.BusDriverService;
import com.fidelit.service.BusService;
import com.fidelit.service.GtsService;
import com.fidelit.service.RouteService;
import com.fidelit.service.StopService;

@Controller
@RequestMapping({"/route"})
public class RouteController {

@Autowired
RouteService routeService;

@Autowired
StopService stopService;

@Autowired
BusService busService;

@Autowired
BusDriverService busDriverService;

@Autowired
GtsService gtsService;
	

	@RequestMapping(value="/addNewStops")
	public String addNewStops(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		int stopCounter = 0;
		int stopNo=0;
		String stopName=null;
		double latitude=0.00;
		double longitude=0.00;
		
		if(request.getParameter("stopNumber") != null){
	       stopNo = Integer.parseInt(request.getParameter("stopNumber"));
		}
		if(request.getParameter("stopsName") != null){
		    stopName = request.getParameter("stopsName");
		}
		if(request.getParameter("latitude") != null){
			latitude = Double.parseDouble(request.getParameter("latitude"));
		}
		if(request.getParameter("longitude") != null){
			longitude = Double.parseDouble(request.getParameter("longitude"));
		}
		int routeId= Integer.parseInt(request.getParameter("routeId"));
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		if(stopName != null){
		 Stop stop= new Stop();
		 Route route=routeService.getRouteId(routeId);
		 String corridorID=route.getCorridorId();
		 stop.setRoute(route);
		 stop.setStopNo(stopNo);
		 stop.setStopName(stopName);
		 stop.setLatitude(latitude);
		 stop.setLongitude(longitude);
		 stopService.addStop(stop);
		 gtsService.addCorridorInGtsList(userName, corridorID, latitude, longitude,stopNo);
		}
		
		Route fetchRoute=routeService.getRouteId(routeId);
		
		List<Stop> stopList =  fetchRoute.getStopList();
	    StringBuilder coordinateList = new StringBuilder();
		for (Stop stop2 : stopList) {
			stopCounter++;
			coordinateList.append(stop2.getLatitude());
			coordinateList.append(",");
			coordinateList.append(stop2.getLongitude());
			coordinateList.append(",");
		}
		stopCounter++;
		model.addAttribute("stopCounter", stopCounter);
		model.addAttribute("stopList", stopList);
		model.addAttribute("routeId", routeId);
		model.addAttribute("coordinateList", coordinateList);
		return "stopMap";
	}
	
	@RequestMapping(value="routeMap")
	public String route(ModelMap model){
		List<Route> routes = routeService.getRouteList();
		System.out.println(routes.toString());
		
		List<Bus> busList=busService.allBusList();
		List<BusDriver> busDriverList=busDriverService.allBusDriverList();
		model.addAttribute("routeList",routes);
		model.addAttribute("busList",busList);
		model.addAttribute("busDriverList",busDriverList);
		model.addAttribute(new Route());
		return "routeMap";
	}

	@RequestMapping(value="addRoute",method = RequestMethod.POST)
	public String addRoute(@ModelAttribute("route") Route route,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		List<Bus> busList=busService.allBusList();
		String busNumber=route.getBus().getRegNumber();
		String driverName=route.getBusDriver().getDriverName();
		List<BusDriver> busDriverList=busDriverService.allBusDriverList();
		Bus bus=busService.getBusRegNo(busNumber);
		BusDriver busDriver=busDriverService.getDriverByName(driverName);
		
		route.setBusDriver(busDriver);
		route.setBus(bus);
	//	route.setAccountId(request.getSession().getValue("currentUser"));
		routeService.addRoute(route);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userName:"+userName);
		gtsService.addCorridorInGts(userName, route.getCorridorId(), route.getRouteName());
		List<Route> routes = routeService.getRouteList();
		model.addAttribute("routeList",routes);
		model.addAttribute("busList",busList);
		model.addAttribute("busDriverList",busDriverList);
		return "routeMap";
	}
	@RequestMapping(value="editRoute",method = RequestMethod.POST)
	public String editRoute(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		System.out.println(list);
		String [] dataList = list.split(",");
		Route route = new Route();
		String busNo=dataList[5];
		String driver=dataList[6];
		String corridorId=dataList[7];
		Bus bus=busService.getBusRegNo(busNo);
		BusDriver busDriver=busDriverService.getDriverByName(driver);
		Integer routeId=Integer.parseInt(dataList[0]);
		route.setRouteNo(routeId);
		route.setRouteName(dataList[1]);
		route.setRouteStatus(true);
		route.setStartStop(dataList[3]);
		route.setEndStop(dataList[4]);
		route.setBus(bus);
		route.setBusDriver(busDriver);
		route.setCorridorId(corridorId);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		gtsService.editCorridorInGts(userName, corridorId, dataList[1]);
		routeService.updateRoute(route);
		return "stopMap";
	}

	
	@RequestMapping(value="editStop",method = RequestMethod.POST)
	public String editStop(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		System.out.println(list);
		String [] dataList = list.split(",");
		Stop stop = new Stop();
		Integer stopNo=Integer.parseInt(dataList[4]);
		Integer routeNo=Integer.parseInt(dataList[5]);
		Integer id=Integer.parseInt(dataList[0]);
		double latitude=Double.parseDouble(dataList[2]);
		double longitude=Double.parseDouble(dataList[3]);
		Route route=routeService.getRouteId(routeNo);
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		String corridorID=route.getCorridorId();
		stop.setRoute(route);
		stop.setStopId(id);
		stop.setStopName(dataList[1]);
		stop.setLatitude(latitude);
		stop.setLongitude(longitude);
		stop.setStopNo(stopNo);
		gtsService.editCorridorInGtsList(userName, corridorID, latitude, longitude, stopNo);
		stopService.updateStop(stop);
		return "stopMap";
	}
	
	@RequestMapping(value = "/deleteRouteList")
	public String deleteParentList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			
			Route route1=routeService.getRouteId(id);
			System.out.println("Route"+route1.getCorridorId());
			gtsService.deleteCorridor(route1.getCorridorId());
			routeService.deleteRoute(id);
			
		}
		

	    List<Route> routeList= routeService.getRouteList();
		model.addAttribute("routeList", routeList);
		model.addAttribute(new Route());
		return "routeMap";
	}
	
	@RequestMapping(value = "/busList")
	public String busList( HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		List<Bus> busList= busService.allBusList();
		model.addAttribute("busList", busList);
		model.addAttribute(new Bus());
		return "busList";
		
	}
	
	@RequestMapping(value="addBus",method = RequestMethod.POST)
	public String addBus(@ModelAttribute("bus") Bus bus,ModelMap model){
		
		busService.addBus(bus);
		List<Bus> busList = busService.allBusList();
		model.addAttribute("busList",busList);
		model.addAttribute(new Bus());
		return "busList";
	}
	
	@RequestMapping(value = "/deleteBusList")
	public String deleteBusList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			busService.deleteBus(id);
		}
		

	    List<Bus> busList= busService.allBusList();
		model.addAttribute("busList", busList);
		model.addAttribute(new Bus());
		return "busList";
	}
	
	@RequestMapping(value="editBus",method = RequestMethod.POST)
	public String editBus(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		String [] dataList = list.split(",");
		Bus bus = new Bus();
		Integer busId=Integer.parseInt(dataList[0]);
		Integer capacity=Integer.parseInt(dataList[3]);
		bus.setBusId(busId);
		bus.setCapacity(capacity);
		bus.setRegNumber(dataList[1]);
		bus.setBusType(dataList[2]);
		model.addAttribute(new Bus());
		busService.updateBus(bus);
		return "busList";
	}
	
	@RequestMapping(value = "/driverList")
	public String busDriverList( HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		List<BusDriver> busDriverList= busDriverService.allBusDriverList();
		model.addAttribute("busDriverList", busDriverList);
		model.addAttribute(new BusDriver());
		return "driverList";
		
	}
	
	@RequestMapping(value="addDriver",method = RequestMethod.POST)
	public String addBusDriver(@ModelAttribute("busDriver") BusDriver driver,ModelMap model){
		
		busDriverService.addBusDriver(driver);
		List<BusDriver> busDriverList = busDriverService.allBusDriverList();
		model.addAttribute("busDriverList",busDriverList);
		model.addAttribute(new BusDriver());
		return "driverList";
	}
	
	@RequestMapping(value="editBusDriver",method = RequestMethod.POST)
	public String editBusDriver(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String list = request.getParameter("list");
		String [] dataList = list.split(",");
		BusDriver busDriver = new BusDriver();
		Integer driverId=Integer.parseInt(dataList[0]);
		Integer age=Integer.parseInt(dataList[6]);
		busDriver.setDriverId(driverId);
		busDriver.setDriverName(dataList[1]);
		busDriver.setAddress(dataList[2]);
		busDriver.setCity(dataList[3]);
		busDriver.setLicenseNo(dataList[4]);
		busDriver.setExperiance(dataList[5]);
		busDriver.setAge(age);
		model.addAttribute(new BusDriver());
		busDriverService.updateBusDriver(busDriver);
		return "driverList";
	}
	
	@RequestMapping(value = "/deleteBusDriverList")
	public String deleteBusDriverList(@RequestParam("list") String str,ModelMap model){
		str = str.substring(0, str.length()-1);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			busDriverService.deleteBusDriver(id);
		}
		

	    List<BusDriver> busDriverList= busDriverService.allBusDriverList();
		model.addAttribute("busDriverList", busDriverList);
		model.addAttribute(new BusDriver());
		return "driverList";
	}

	
	
	

}
