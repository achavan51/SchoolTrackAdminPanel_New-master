package com.fidelit.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.Extintor;
import com.fidelit.model.Route;
import com.fidelit.service.ExtinctorService;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("extintorService")
public class ExtinctorServiceImpl implements ExtinctorService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateExtintor(Extintor extinctor) {
		
		
		Session session;
		try {
			
			session = sessionFactory.getCurrentSession();
			session.update(extinctor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addExtintor(Extintor extinctor) {
	
		Session session = sessionFactory.getCurrentSession();
		session.save(extinctor);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Extintor> getExtintorList(String userName) {
		
		List<Extintor> extintorList = new ArrayList<Extintor>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql ="from Extintor where accountId= :accountId"; 
				Query query = session.createQuery(hql);
				query.setParameter("accountId", userName);
				extintorList = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return extintorList;
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Extintor getExtintorId(int id) {
		Session session;
		Extintor  extintor = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Extintor.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 extintor = (Extintor)result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return extintor;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteExtintor(int id) {
		
		Session session;
		Extintor  extintor=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Extintor.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 extintor = (Extintor)result;
			 session.delete(extintor);
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteBusInExtinctor(int busId) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
			String hql = "UPDATE extintor set bus_busId = null "  + 
		             "WHERE bus_busId = "+busId;
			try{
			Query query = session.createSQLQuery(hql);
			System.out.println("update :"+query.executeUpdate());
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public List<Extintor> allExtintorListForBus(String busID) {
		
		Session session;
		List<Extintor> extintorList = null;
		try{
			session = sessionFactory.getCurrentSession();
			System.out.println("IN Service:"+busID);
			SQLQuery query = session.createSQLQuery(
					"select * from extintor e where e.bus_busId ='"+busID+"'");		
			extintorList = query.list();
			System.out.println("In ExtintorService:"+extintorList.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return extintorList;
	}

	

}
