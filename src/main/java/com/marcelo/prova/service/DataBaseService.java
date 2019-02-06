package com.marcelo.prova.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.prova.model.Poi;
import com.marcelo.prova.repository.PoiRepository;

@Service
public class DataBaseService {
	@Autowired
	private PoiRepository poiDao;
	
	public void instantiateTestDatabase() throws ParseException {

		Poi lanchonete = new Poi(null, "Lanchonete", 27, 12);
		Poi posto = new Poi(null, "Posto", 31, 18);
		Poi joalheria = new Poi(null, "Joalheria", 15, 18);
		Poi floricultura = new Poi(null, "Floricultura", 19, 21);
		Poi pub = new Poi(null, "Pub", 12, 8);
		Poi supermecado = new Poi(null, "Supermercado", 23, 6);
		Poi churrascaria = new Poi(null, "Churrascaria", 28, 2);
		
		poiDao.saveAll(Arrays.asList(lanchonete,posto,joalheria,floricultura,pub,supermecado,churrascaria));
	}
}
