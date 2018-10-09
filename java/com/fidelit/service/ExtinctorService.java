package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Extintor;

public interface ExtinctorService {
	
	void updateExtintor(Extintor extinctor);
	void addExtintor(Extintor extinctor);
	List<Extintor> getExtintorList();
	Extintor getExtintorId(int id);
	void deleteExtintor(int id);

}
