package com.marcelo.prova.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.prova.model.Poi;
import com.marcelo.prova.service.PoiServiceControl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/poi")
@Api(value="XY-INC")
@CrossOrigin(origins="*")
public class PoiResource {
	@Autowired
	private PoiServiceControl poiServiceControl;

	@GetMapping
	@ApiOperation(value="Lista Pontos de Interesse Cadastrados")
	public ResponseEntity<List<Poi>> listaPoi() {
		List<Poi> listAll = poiServiceControl.listaPoi();

		return ResponseEntity.ok().body(listAll);
	}

	
	@RequestMapping(value = "/listaPoiProximo", method = RequestMethod.GET)
	@ApiOperation(value="Lista Pontos de Interesse por Proximidade")
	public ResponseEntity<List<Poi>> listaPoiProximo(
			@RequestParam(value = "x", defaultValue = "1") Integer x,
			@RequestParam(value = "y", defaultValue = "1") Integer y,
			@RequestParam(value = "distancia", defaultValue = "1") Integer distancia) {
		List<Poi> listAll = poiServiceControl.listaPoi();
		List<Poi> listReturn = new ArrayList<Poi>();
		
		for(Poi poi : listAll) {
			double euclidiana = Math.sqrt(Math.pow((poi.getX() - x),2) + Math.pow((poi.getY() - y),2));
			if(euclidiana <= distancia) {
				listReturn.add(poi);
			}
		}
		return ResponseEntity.ok().body(listReturn);
	}

	@PostMapping
	@ApiOperation(value="Cadastra Pontos de Interesse")
	public ResponseEntity<Void> cadastraPoi(@Valid @RequestBody Poi poi) {
		Poi objResponse = poiServiceControl.cadastraPoi(poi);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objResponse.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
