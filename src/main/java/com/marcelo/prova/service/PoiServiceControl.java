package com.marcelo.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.prova.DAO.PoiDAO;
import com.marcelo.prova.model.Poi;

@Service
public class PoiServiceControl {

	@Autowired 
	private PoiDAO poiDAO; 
	
	public List<Poi> listaPoi() {
		return poiDAO.findAll();
	}
	
	public Poi cadastraPoi(Poi poi) {
		poi.setId(null);
	
		if(poi.getX() == null) {
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro X");
		}
			
		if(poi.getY() == null){
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro Y");
		}
		
		if(poi.getName() == null) {
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro NOME");
		}
		return poiDAO.save(poi); 
	}
}
