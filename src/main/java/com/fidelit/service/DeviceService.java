package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Device;

public interface DeviceService {

	List<Device> getAllDeviceByUsername(String userName);

	void addOrUpdateDevice(Device device);

	void deleteDeviceByUniqueIdAndAccountId(String uniqueId,
			String userName);

	List<Device> getDeviceListByUsername(String username);

	Device getDeviceByUniqueId(String uniqueID);
}
