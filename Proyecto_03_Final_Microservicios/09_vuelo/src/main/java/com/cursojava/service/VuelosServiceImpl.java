package com.cursojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.dao.VuelosDao;
import com.cursojava.model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService{

	@Autowired
	VuelosDao dao;
	
	@Override
	public List<Vuelo> findAllVuelos() {
		return dao.findAll();
	}

	@Override
	public List<Vuelo> findVuelosDisponibles(int plazas) {
		return dao.findByPlazasGreaterThanEqual(plazas);
	}

	@Override
	public List<Vuelo> findVuelosCompañia(String compañia) {
		return dao.findByCompañia(compañia);
	}
	
	/**
	 * Este método comprueba si las plazas solicitadas es mayor que
	 * las solicitadas. Si esto no ocurre, no se actualiza el vuelo
	 * y se considera no satisfecha la operación (de momento no se hace nada)
	 */
	@Override
	public void updateVuelo(int id, int plazas) {
		Vuelo v = dao.findById(id).orElse(null);
		
		if(v.getPlazas() >= plazas) {			
			v.setPlazas(v.getPlazas() - plazas);
			dao.save(v);
		}
	}


}
