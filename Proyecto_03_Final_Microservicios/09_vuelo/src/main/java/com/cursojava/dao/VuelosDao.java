package com.cursojava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {

	/**
	 * Método que se encarga de obtener y devolver los vuelos disponibles 
	 * de la base de datos teniendo en cuenta el numero de plazas 
	 * solicitadas
	 * 
	 * @param plazas
	 * @return
	 */
	List<Vuelo> findByPlazasGreaterThanEqual(int plazas);
	
	/**
	 * Método que se encarga de obtener y devolverlos vuelos de la base de datos
	 * según la compañía
	 * 
	 * @param company
	 * @return
	 */
	List<Vuelo> findByCompany(String company);
	
}
