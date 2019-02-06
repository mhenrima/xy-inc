package com.marcelo.prova.model;

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

import com.marcelo.prova.repository.PoiRepository;
import com.marcelo.prova.service.PoiServiceControl;

@RunWith(MockitoJUnitRunner.class)
public class PoiServiceControlTest {
	
	@InjectMocks
	PoiServiceControl subject;
	
	@Spy
	private List<Poi> listPoi = new ArrayList<>();
	
	@Mock
	private PoiRepository poiDAO; 
	
	@Test
	public void test4ListaPoi() {
		//preparacao
		when(poiDAO.findAll()).thenReturn(listPoi);
				
		//execucao
		subject.listaPoi();
		
		//verificacao
		verify(poiDAO).findAll();
	}
	
	@Test
	public void test4SucessCadastraPoi() {
		//preparacao
		Poi poi = new Poi();
		poi.setName("teste");
		poi.setX(21);
		poi.setY(12);
		
		//execucacao
		subject.cadastraPoi(poi);
		//verificacao
		verify(poiDAO).save(poi);
		
	}
	@Test(expected = NullPointerException.class) 
	public void test4XnullCadastraPoi()  {
		//preparacao
		Poi poi = new Poi();
		poi.setName("teste");
		poi.setX(null);
		poi.setY(12);
		
		//execucacao
		subject.cadastraPoi(poi);
		
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4YnullCadastraPoi()  {
		//preparacao
		Poi poi = new Poi();
		poi.setName("teste");
		poi.setX(12);
		poi.setY(null);
		
		//execucacao
		subject.cadastraPoi(poi);
		
	}
	
	@Test(expected = NullPointerException.class) 
	public void test4NameNullCadastraPoi()  {
		//preparacao
		Poi poi = new Poi();
		poi.setName(null);
		poi.setX(12);
		poi.setY(41);
		
		//execucacao
		subject.cadastraPoi(poi);
		
	}
}
