package com.fidelit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidelit.model.Device;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.service.DeviceService;
import com.fidelit.service.GtsService;

@Controller
@RequestMapping({"/device"})
public class DeviceController {
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	GtsService gtsService;
	
	@RequestMapping(value="/deviceList")
	String getDeviceList(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Device> deviceList = deviceService.getAllDeviceByUsername(userName);
		
		HttpSession session = request.getSession();
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
		String username = currentUser.getUsername();
		model.addAttribute("userName", username);
		
		model.addAttribute("deviceList",deviceList);
		model.addAttribute("device",new Device());
		model.addAttribute("deviceActive", "deviceActive");
		return "device";
	}
	
	@RequestMapping(value="/addDevice")
	String addDevice(@ModelAttribute("device") Device device,HttpServletRequest request,HttpServletResponse response,ModelMap model){

        HttpSession session = request.getSession();
		SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
    	String userName = currentUser.getUsername();
    	
		device.setAccountID(userName);
		deviceService.addOrUpdateDevice(device);
		gtsService.addDeviceInGts(device);
        List<Device> deviceList = deviceService.getAllDeviceByUsername(userName);
		
    	model.addAttribute("userName", userName);
        model.addAttribute("deviceList",deviceList);
		model.addAttribute("device",new Device());
		model.addAttribute("deviceActive", "deviceActive");
		return "device";
	}
	
	@RequestMapping(value="/updateDevice")
	String updateDevice(@ModelAttribute("device") Device device,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		device.setAccountID(userName);
		deviceService.addOrUpdateDevice(device);
		gtsService.updateDeviceInGts(device);
        List<Device> deviceList = deviceService.getAllDeviceByUsername(userName);
		
        HttpSession session = request.getSession();
    	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
    	String username = currentUser.getUsername();
    	model.addAttribute("userName", username);
    	
        model.addAttribute("deviceList",deviceList);
		model.addAttribute("device",new Device());
		model.addAttribute("deviceActive", "deviceActive");
		return "device";
	}
	
	@RequestMapping(value="/deleteDevice")
	String deleteDevice(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		String uniqueId = request.getParameter("uniqueIdList");
		String uniqueIdList[] = uniqueId.split(",");
		for (String string : uniqueIdList) {
			 deviceService.deleteDeviceByUniqueIdAndAccountId(string,userName);
		     gtsService.deleteDeviceByUniqueIdAndAccountIdInGts(string, userName);
		}
		System.out.println("**********"+uniqueId);
		
        List<Device> deviceList = deviceService.getAllDeviceByUsername(userName);
		
        HttpSession session = request.getSession();
    	SchoolAdmin currentUser = (SchoolAdmin) session.getAttribute("currentUser");
    	String username = currentUser.getUsername();
    	model.addAttribute("userName", username);
    	
        
        model.addAttribute("deviceList",deviceList);
		model.addAttribute("device",new Device());
		model.addAttribute("deviceActive", "deviceActive");
		return "device";
	}
	
}
