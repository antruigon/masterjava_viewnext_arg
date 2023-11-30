package com.cursojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.dao.PromocionesDao;
import com.cursojava.model.Promocion;

@Service
public class PromocionesServiceImpl implements PromocionesService {

	@Autowired
	PromocionesDao dao;
	
	@Override
	public List<Promocion> findAllPromociones() {
		return dao.findAll();
	}
	
	@Override
	public List<Promocion> findPromocionesActivas() {
		return dao.findByActivaTrue();
	}

	@Override
	public void postPromocion(Promocion promocion) {
		dao.save(promocion);
	}

	@Override
	public Promocion findPromocionById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void putPromocion(int id) {
		Promocion promocion = this.findPromocionById(id);
		Boolean activaDesactiva = promocion.getActiva() ? false : true;
		promocion.setActiva(activaDesactiva);
		
		dao.save(promocion);
	}

}
