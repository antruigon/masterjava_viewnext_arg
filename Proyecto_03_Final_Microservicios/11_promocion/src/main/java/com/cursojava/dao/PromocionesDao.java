package com.cursojava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.model.Promocion;

public interface PromocionesDao extends JpaRepository<Promocion, Integer> {

	/**
	 * Método que devuelve todas las promociones ACTIVAS
	 * 
	 * @return
	 */
	List<Promocion> findByActivaTrue();
	
}
