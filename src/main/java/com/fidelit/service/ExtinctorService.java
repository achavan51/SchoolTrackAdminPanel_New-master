package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Extintor;

public interface ExtinctorService {
	
	void updateExtintor(Extintor extinctor);
	void addExtintor(Extintor extinctor);
	List<Extintor> getExtintorList(String userName);
	Extintor getExtintorId(int id);
	void deleteExtintor(int id);
	void deleteBusInExtinctor(int id);
	List<Extintor> allExtintorListForBus(String busID);

}
