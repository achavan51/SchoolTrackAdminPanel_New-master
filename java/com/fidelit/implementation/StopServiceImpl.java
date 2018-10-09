package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.School;
import com.fidelit.model.Stop;
import com.fidelit.service.StopService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("StopService")
public class StopServiceImpl implements StopService{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addStop(Stop stop) {
		
		 Session session;
			try {	
					System.out.println("sdfg");
					session = sessionFactory.getCurrentSession();
					session.save(stop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateStop(Stop stop) {
		// TODO Auto-generated method stub
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(stop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Stop> getAllStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stop> allStopList() {
		
		List<Stop> stopList = new ArrayList<Stop>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(Stop.class);
				stopList = criteria.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		 
		 return stopList;
	}

	@Override
	public Stop getStopId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stop getStop(String stopName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStop(int id) {
		
		Session session;
		Stop  stop=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Stop.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 stop = (Stop)result;
			 session.delete(stop);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
