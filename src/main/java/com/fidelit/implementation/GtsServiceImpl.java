package com.fidelit.implementation;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fidelit.model.Device;
import com.fidelit.service.GtsService;

public class GtsServiceImpl implements GtsService{

	@Autowired
	@Qualifier("gtsSessionFactory")
	SessionFactory sessionFactory; 
	
	@Override
	public void addAccountInGts(String accountId,String password,String description) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		
        StringBuilder builder = new StringBuilder();		
        builder.append(" INSERT INTO `gts`.`Account`(`accountID`,`accountType`,`notifyEmail`,`allowNotify`,`speedUnits`,`distanceUnits`,`volumeUnits`,`pressureUnits`,`economyUnits`,`temperatureUnits`,");
        builder.append("`currencyUnits`,`fuelCostPerLiter`,`latLonFormat`,`geocoderMode`,`privateLabelName`, `isBorderCrossing`,`retainedEventAge`,`maximumDevices`,`totalPingCount`,");
        builder.append("`maxPingCount`,`autoAddDevices`,`dcsPropertiesID`,`smsEnabled`,`smsProperties`,`emailProperties`,`expirationTime`,`allowWebService`,`defaultUser`,`password`,");
		builder.append("`contactName`,`contactPhone`,`contactEmail`,`timeZone`,`passwdChangeTime`,`passwdQueryTime`,`lastLoginTime`,`isActive`,`displayName`,`description`, `notes`,");
		builder.append("`lastUpdateTime`,`creationTime`,`mapLegendDevice`,`mapLegendGroup`,`isAccountManager`,`managerID`,`requestPassCode`,`requestIPAddress`,`dataPushURL`,");
	    builder.append("`lastDataRequestTime`,`lastDataPushTime`)");
	    
	    builder.append(" VALUES('"+accountId +"',0,'',1,0,0,0,0,0,0,");
	    builder.append("'',0,0,3,' *', 0,0,0,0,");
	    builder.append("0,0,'',1,'','',0,0,'','"+password +"',");
	    builder.append("'','','',0,0,0,0,1,'','System Administrator', '',");
	    builder.append("0,0,'','',0,'','','','',");
	    builder.append("'0','0');");
	    
		System.out.println("builder.toString()"+builder.toString());
	    Query query = session.createSQLQuery(builder.toString());
		query.executeUpdate();
		
		session.close();
	
	}
	

	@Override
	public void editAccountInGts(String accountId, String password,
			String description) {
		 Session session = sessionFactory.openSession();
		   String sql = "delete from Account where accountID='"+accountId+"'";
		   SQLQuery query = session.createSQLQuery(sql);	
		   query.executeUpdate();		
		  

	        StringBuilder builder = new StringBuilder();		
	        builder.append(" INSERT INTO `gts`.`Account`(`accountID`,`accountType`,`notifyEmail`,`allowNotify`,`speedUnits`,`distanceUnits`,`volumeUnits`,`pressureUnits`,`economyUnits`,`temperatureUnits`,");
	        builder.append("`currencyUnits`,`fuelCostPerLiter`,`latLonFormat`,`geocoderMode`,`privateLabelName`, `isBorderCrossing`,`retainedEventAge`,`maximumDevices`,`totalPingCount`,");
	        builder.append("`maxPingCount`,`autoAddDevices`,`dcsPropertiesID`,`smsEnabled`,`smsProperties`,`emailProperties`,`expirationTime`,`allowWebService`,`defaultUser`,`password`,");
			builder.append("`contactName`,`contactPhone`,`contactEmail`,`timeZone`,`passwdChangeTime`,`passwdQueryTime`,`lastLoginTime`,`isActive`,`displayName`,`description`, `notes`,");
			builder.append("`lastUpdateTime`,`creationTime`,`mapLegendDevice`,`mapLegendGroup`,`isAccountManager`,`managerID`,`requestPassCode`,`requestIPAddress`,`dataPushURL`,");
		    builder.append("`lastDataRequestTime`,`lastDataPushTime`)");
		    
		    builder.append(" VALUES('"+accountId +"',0,'',1,0,0,0,0,0,0,");
		    builder.append("'',0,0,3,' *', 0,0,0,0,");
		    builder.append("0,0,'',1,'','',0,0,'','"+password +"',");
		    builder.append("'','','',0,0,0,0,1,'','System Administrator', '',");
		    builder.append("0,0,'','',0,'','','','',");
		    builder.append("'0','0');");
		    
			System.out.println("builder.toString()"+builder.toString());
		    Query queryy = session.createSQLQuery(builder.toString());
			queryy.executeUpdate();
		
			session.close();
		
	}

	
	@Override
	public void addCorridorInGts(String accountId,String corridorID,String description) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println("In add Corridor In Gts:"+corridorID);
		String sql = "insert into GeoCorridor (accountID,corridorID,description) values('"+accountId +"','"+corridorID +"','"+description +"')";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		System.out.println(" In addCorridorInGts");
		session.close();
	}


	@Override
	public void addCorridorInGtsList(String accountId, String corridorID,
			double latitude, double longitude, int stopID) {
		Session session = sessionFactory.openSession();
		String sql=null;
		if(stopID==1){
			sql="insert into GeoCorridorList (accountID,corridorID,latitude"+stopID+",longitude"+stopID+",sortID) values('"+accountId +"','"+corridorID +"',"+latitude+stopID +","+longitude+stopID +",1)"; 
		}else{
			sql="update GeoCorridorList set latitude"+stopID+" = "+latitude +", longitude"+stopID+" ="+longitude +"where corridorID = '"+corridorID +"'" ;
		}
		Query query = session.createSQLQuery(sql);
		System.out.println("in addCorridorInGtsList");
		query.executeUpdate();
		session.close();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCorridorInGts(String accountId, String corridorID,
			String description) {
		
		Session session = sessionFactory.openSession();
		System.out.println("ON editcorridor");
		String sql = "update GeoCorridor set accountID = '"+accountId+"', corridorID ='"+corridorID+"' , description ='"+description+"' where corridorID = '"+corridorID+"'";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.close();
		
	}

	@Override
	public void editCorridorInGtsList(String accountId, String corridorID,
			double latitude, double longitude, int stopID) {
		
		Session session = sessionFactory.openSession();
		System.out.println("ON editcorridorList");
		String  sql="update GeoCorridorList set latitude"+stopID+" = "+latitude +", longitude"+stopID+" ="+longitude +"where corridorID = '"+corridorID +"'" ;
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		session.close();
		
	}

	@Transactional
	@Override
	public void deleteCorridor(String corridorID) {
		
		Session session = sessionFactory.openSession();
		String sql = "delete from GeoCorridor where corridorID = '"+corridorID+"'";
		String sql1= "delete from GeoCorridorList where corridorID = '"+corridorID+"'";
		Query query = session.createSQLQuery(sql);
		Query query1=session.createSQLQuery(sql1);
		query1.executeUpdate();
		query.executeUpdate();
		session.close();
	}


	@Transactional
	@Override
	public void addDeviceInGts(Device device) {
		try{
		   Session session = sessionFactory.openSession();
	
		   String sql = "insert into Device (uniqueID,accountID,deviceID,allowNotify,description,isActive) "
		   		+ "values('"+device.getUniqueID()+"','"+device.getAccountID()+"','"+device.getDeviceID()+"',"+device.getAllowNotify()+",'"
		   		+ device.getDescription()+"',"+device.getIsActive()+");";
				   
		   SQLQuery query = session.createSQLQuery(sql);	
		   query.executeUpdate();		
		   System.out.println("In gts ");
		   session.close();
		   
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	@Transactional
	@Override
	public void updateDeviceInGts(Device device) {
		try{
			   Session session = sessionFactory.openSession();
		
			   String sql = "update Device set deviceID = '"+device.getAccountID()+"',allowNotify="+device.getAllowNotify()+",description = '"+ device.getDescription()+"',isActive ="+device.getIsActive()+" where uniqueId = '"+device.getUniqueID()+"';";
					   
			   SQLQuery query = session.createSQLQuery(sql);	
			   query.executeUpdate();		
			   System.out.println("In gts ");
			   session.close();
			   
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	@Transactional
	@Override
	public void deleteDeviceByUniqueIdAndAccountIdInGts(String uniqueId,
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
	

	@Transactional
	@Override
	public void deleteDeviceInGts(String accountID) {
		try{
			   Session session = sessionFactory.openSession();
			   String sql = "delete from Account where accountID='"+accountID+"'";
			   SQLQuery query = session.createSQLQuery(sql);	
			   query.executeUpdate();		
			   session.close();
			   
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}

	@Transactional
	@Override
	public void deleteAccountInGts(String accountId) {
		
		try{
			System.out.println("IN gts delete Acc");
			   Session session = sessionFactory.openSession();
			   String sql = "delete from Account where accountID='"+accountId+"'";
			   SQLQuery query = session.createSQLQuery(sql);	
			   query.executeUpdate();		
			   session.close();
			   
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
}
