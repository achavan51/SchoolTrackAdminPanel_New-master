package com.fidelit.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Device;
import com.fidelit.service.DeviceService;
import com.fidelit.service.GtsService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("gtsSessionFactory")
	SessionFactory gtsSessionFactory; 
	
	
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Device> getAllDeviceByUsername(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Device where accountID = :accountID";
		Query query = session.createQuery(hql);
		query.setString("accountID", userName);
		List<Device> deviceList  = query.list();
		return deviceList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void addOrUpdateDevice(Device device) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(device);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void deleteDeviceByUniqueIdAndAccountId(String uniqueId,
			String userName) {
		try{
			   Session session = sessionFactory.openSession();
			   String sql = "delete from Device where uniqueId='"+uniqueId+"' and accountID = '"+userName+"' ";
			   SQLQuery query = session.createSQLQuery(sql);	
			   query.executeUpdate();		
			   session.close();
			   
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public List<Device> getDeviceListByUsername(String userName) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Device where accountID = :accountID and isDeviceUsed = :isDeviceUsed";
		Query query = session.createQuery(hql);
		query.setString("accountID", userName);
		query.setBoolean("isDeviceUsed", false);
		List<Device> deviceList  = query.list();
		return deviceList;
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public Device getDeviceByUniqueId(String uniqueID) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Device where uniqueID = :uniqueID";
		Query query = session.createQuery(hql);
		query.setString("uniqueID", uniqueID);
		Device device  = (Device) query.uniqueResult();
		return device;
	}
		

}
