package com.fidelit.service;

import com.fidelit.model.Account;
import com.fidelit.model.SchoolAdmin;

public interface AuthenticationService {

	
public SchoolAdmin authenticateUser(String username,String password,String accountId);

SchoolAdmin authenticateUser(String username);


}
