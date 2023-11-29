package com.cursojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.dao.HotelesDao;
import com.cursojava.model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {

	@Autowired
	HotelesDao dao;
	
	@Override
	public List<Hotel> findAllHoteles() {
		return dao.findAll();
	}

	@Override
	public List<Hotel> findHotelesDisponibles() {
		return dao.findByDisponibleTrue();
	}
	
	@Override
	public Hotel findHotelNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

	@Override
	public List<Hotel> findHotelCategoria(String categoria) {
		return dao.findByCategoria(categoria);
	}

}
