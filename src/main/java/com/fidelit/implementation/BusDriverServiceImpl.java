package com.fidelit.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Bus;
import com.fidelit.model.BusDriver;
import com.fidelit.service.BusDriverService;

public class BusDriverServiceImpl implements BusDriverService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addBusDriver(BusDriver busDriver) {
		Session session;
		try {	
			session = sessionFactory.getCurrentSession();
			session.save(busDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateBusDriver(BusDriver busDriver) {
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(busDriver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 @Override
	 public List<BusDriver> allBusDriverList(String userName) {
	 
	  Session session;
	  List<BusDriver> busDriverList = null;
	  try{
	   session = sessionFactory.getCurrentSession();
	   Query query = session.createQuery("from BusDriver where accountId =:accountId");
	   query.setString("accountId", userName);
	   busDriverList = query.list();
	  }
	  catch(Exception e){
	   e.printStackTrace();
	  }
	  return busDriverList;
	 }

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public BusDriver getBusDriverId(int id) {
		Session session;
		BusDriver  busDriver = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(BusDriver.class);
			 criteria.add(Restrictions.eq("driverId", id));
			 Object result=criteria.uniqueResult();
			 busDriver = (BusDriver)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return busDriver;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteBusDriver(int id) {
		Session session;
		BusDriver  busDriver=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(BusDriver.class);
			 criteria.add(Restrictions.eq("driverId", id));
			 Object result=criteria.uniqueResult();
			 busDriver = (BusDriver)result;
			 session.delete(busDriver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public BusDriver getDriverByName(String driverName) {
		
		Session session;
		BusDriver  busDriver = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(BusDriver.class);
			 criteria.add(Restrictions.eq("driverName", driverName));
			 Object result=criteria.uniqueResult();
			 busDriver = (BusDriver)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return busDriver;
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public BusDriver getDriverById(int driverId) {
		
		Session session;
		BusDriver  busDriver = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(BusDriver.class);
			 criteria.add(Restrictions.eq("driverId", driverId));
			 Object result=criteria.uniqueResult();
			 busDriver = (BusDriver)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return busDriver;
	}

}
