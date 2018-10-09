package com.fidelit.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 public class ExUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String dbValue = request.getParameter("account");
        request.getSession().setAttribute("dbValue", dbValue);
        System.out.println("***********UsernamePasswordAuthenticationFilter**************");
        return super.attemptAuthentication(request, response); 
    } 
}