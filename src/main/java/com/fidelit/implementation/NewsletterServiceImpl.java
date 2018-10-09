package com.fidelit.implementation;

import com.fidelit.controller.SchoolAppNotificationForAndroid;
import com.notnoop.apns.SchoolAppNotificationForIOS;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsAnything;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier; 
import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fidelit.model.AddDeviceForNotification;
import com.fidelit.model.Newsletter;
import com.fidelit.service.NewsletterService;
import com.google.android.gcm.server.Result;
import com.notnoop.exceptions.InvalidSSLConfig;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("newsletterService")
public class NewsletterServiceImpl implements NewsletterService{

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Autowired
	@Qualifier("gtsSessionFactory")
	SessionFactory schoolTrackSessionFactory;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addNewsletter(Newsletter newsletter) {
		
		SchoolAppNotificationForAndroid notificationAndroid = new SchoolAppNotificationForAndroid();
		SchoolAppNotificationForIOS notificationIOS = new SchoolAppNotificationForIOS();
		Session schoolSession = sessionFactory.openSession();
		String hql = "from AddDeviceForNotification";
		Query query = schoolSession.createQuery(hql);
		
		List<AddDeviceForNotification> results =   query.list();
		for(AddDeviceForNotification result: results){
			
			Boolean isAdnroid=result.getIsAndroid();
		   
			if(isAdnroid){
				String regId=result.getRegistrationNo();
				notificationAndroid.sendNotification(regId,newsletter.getNews());
			}else
				try {
					 String goodToken = result.getTokenId();
					notificationIOS.sendNotification(goodToken,newsletter.getNews());
				} catch (InvalidSSLConfig | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		  
		
		
		
		
		
		System.out.println("results :"+results);
		
//		String regId = "APA91bFeT5Z9WaMnn_DPtwiV9DLhL8EFcBFzOR-8CVy1dPdylEHmLeeTCA0GXmDxaF33IRMti_lZy7fKF404PhaL9HJJvJkwSPmSuj0xIVx7GD_Xew0V4DA";
//		notificationAndroid.sendNotification(regId);
	//	String hql = "FROM AddDeviceForNotification";
	//	Query query = schoolSession.createQuery(hql);
		

		Session session = sessionFactory.getCurrentSession();
		session.save(newsletter);
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Newsletter> getNewsletterList(String userName) {
		
		List<Newsletter> newsletter = new ArrayList<Newsletter>();
		 Session session;
			try {
				session = sessionFactory.getCurrentSession();
				String hql ="from Newsletter where accountId =:accountId"; 
				Query query = session.createQuery(hql);
				query.setParameter("accountId", userName);
				newsletter = query.list();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return newsletter;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Newsletter getNewsletterId(int id) {
		Session session;
		Newsletter  newsletter = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Newsletter.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 newsletter = (Newsletter)result;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return newsletter;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteNewsletter(int id) {
		Session session;
		Newsletter  newsletter=null;
		System.out.println("NewsLetter calling :"+id);
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Newsletter.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 newsletter = (Newsletter)result;
			 session.delete(newsletter);
			//System.out.println(empList);
		}
		catch(Exception e){
			e.printStackTrace();
		
			}

	}
}
