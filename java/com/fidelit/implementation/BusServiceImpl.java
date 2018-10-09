package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Bus;
import com.fidelit.model.Clients;
import com.fidelit.service.BusService;

public class BusServiceImpl implements BusService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addBus(Bus bus) {
		 Session session;
			try {	
				session = sessionFactory.getCurrentSession();
				session.save(bus);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public void updateBus(Bus bus) {
		
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(bus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Bus> getAllBus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Bus> allBusList() {
		
		Session session;
		List<Bus> busList = null;
		try{
			session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from bus ").addEntity(Bus.class);
			busList = query.list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return busList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Bus getBusId(int id) {
		
		Session session;
		Bus  bus = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Bus.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 bus = (Bus)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return bus;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	@Override
	public void deleteBus(int id) {
		
		Session session;
		Bus  bus=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Bus.class);
			 criteria.add(Restrictions.eq("busId", id));
			 Object result=criteria.uniqueResult();
			 bus = (Bus)result;
			 session.delete(bus);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Bus getBusRegNo(String regNo) {
		Session session;
		Bus  bus = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Bus.class);
			 criteria.add(Restrictions.eq("regNumber", regNo));
			 Object result=criteria.uniqueResult();
			 bus = (Bus)result;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return bus;	
	}

}
