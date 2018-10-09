package com.fidelit.controller;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String username;
    private final String password;
    private final String account;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        account = request.getParameter("account");
        System.out.println("*******"+username+" "+password+""+account);
        HttpSession session = request.getSession();
        session.setAttribute("currentAccountType", account);
    }

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAccount() {
		return account;
	}

   
    //TODO override hashCode, equals and toString to include yourParameter

}