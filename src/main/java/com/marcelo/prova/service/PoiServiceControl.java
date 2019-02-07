package com.marcelo.prova.service;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.prova.model.Poi;
import com.marcelo.prova.repository.PoiRepository;

@Service
public class PoiServiceControl {

	@Autowired 
	private PoiRepository poiDAO;
	private String obj; 
	
	public List<Poi> listaPoi() {
		return poiDAO.findAll();
	}
	
	public Poi cadastraPoi(Poi poi) {
		poi.setId(null);
	
		obj = "";
		if(poi.getX() == null || poi.getX().equals(obj)) {
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro X");
		}
			
		if(poi.getY() == null || poi.getY().equals(obj)){
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro Y");
		}
		
		if(poi.getName() == null || poi.getName() == obj) {
			throw new NullPointerException("Eh obrigatorio o preenchimento do parametro NOME");
		}
		
		if(poi.getX() < 0) {
			throw new InvalidParameterException("O valor do parametro X nao pode ser menor que 0");
		}
		if (poi.getY() < 0) {
			throw new InvalidParameterException("O valor do parametro Y nao pode ser menor que 0");
		}
		
		return poiDAO.save(poi); 
	}
}
