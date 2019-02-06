package com.marcelo.prova.resources;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.marcelo.prova.model.Poi;
import com.marcelo.prova.repository.PoiDAO;
import com.marcelo.prova.service.PoiServiceControl;

@RunWith(MockitoJUnitRunner.class)
public class PoiResourceTest {
	
	@InjectMocks
	PoiResource subject;
	
	@Mock
	PoiServiceControl poiServiceControl;
	
	@Mock
	PoiDAO poiDAO; 
	
	
	
	@Spy
	private List<Poi> listPoi = new ArrayList<>();
	
	
	
	@Test
	public void test4ListaPoi() throws Exception {
		//preparacao
		when(poiServiceControl.listaPoi()).thenReturn(listPoi);
		
		//execucacao
		subject.listaPoi();
		
		//verificacao
		verify(poiServiceControl).listaPoi();
	}
	
	@Test
	public void test4ListaPoiProximo() {
		//preparacao
		Poi lanchonete = new Poi(null, "Lanchonete", 27, 12);
		Poi posto = new Poi(null, "Posto", 31, 18);
		List<Poi> listaMockada = new ArrayList<>();
		listaMockada.add(lanchonete);
		listaMockada.add(posto);
		when(poiServiceControl.listaPoi()).thenReturn(listaMockada);
		
		//execucacao
		subject.listaPoiProximo(20,10,10);
		
		//verificacao
		verify(poiServiceControl).listaPoi();
	}
	
	@Test
	public void test4CadastraPoi() {
		//preparacação
		Poi poi = mock(Poi.class);
		when(poiServiceControl.cadastraPoi(poi)).thenReturn(poi);
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	    
		//execucao
		subject.cadastraPoi(poi);
		//verificacao
		verify(poiServiceControl).cadastraPoi(poi);
		
	}
}
