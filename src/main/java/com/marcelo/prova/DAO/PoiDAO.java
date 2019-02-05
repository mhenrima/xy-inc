package com.marcelo.prova.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.prova.model.Poi;

public interface PoiDAO extends JpaRepository<Poi,Integer>{

}
