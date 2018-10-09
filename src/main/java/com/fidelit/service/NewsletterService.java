package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Newsletter;
import com.fidelit.model.Route;

public interface NewsletterService {
	
	void addNewsletter(Newsletter newsletter);
	List<Newsletter> getNewsletterList(String userName);
	Newsletter getNewsletterId(int id);
	void deleteNewsletter(int id);
	
}
