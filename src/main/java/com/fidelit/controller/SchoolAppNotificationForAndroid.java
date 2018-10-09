package com.fidelit.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter; 

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;


public class SchoolAppNotificationForAndroid {
	
	 private static final long serialVersionUID = 1L;

	    // Put your Google API Server Key here
	    private static final String GOOGLE_SERVER_KEY = "AIzaSyAJmuaUzU4fA_srN-uFzKsSOhQYbTZMi2g";
	    static final String MESSAGE_KEY = "message";    

	
	    public String sendNotification(String regId,String news)
	    {
	    	Result result = null;
	    	try
	        {

	        String share = "";
	        

	        // GCM RedgId of Android device to send push notification        
	       
	        Sender sender = new Sender(GOOGLE_SERVER_KEY);
	        Message message = new Message.Builder().timeToLive(30)
	                        .delayWhileIdle(true).addData(MESSAGE_KEY, news).build();
	        System.out.println("regId: " + regId);
	        result = sender.send(message, regId, 1);
	        System.out.println("\n\n result----"+result.toString());
	    
	            } catch (IOException ioe) {
	                ioe.printStackTrace();
	            
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        return result.toString();
	            
	        }


}
