package com.cursojava.service;

import java.util.List;

import com.cursojava.model.Vuelo;

public interface VuelosService {

	/**
	 * Método que devuelve todos los vuelos
	 * @return
	 */
	List<Vuelo> findAllVuelos();
	
	/**
	 * Método que devuelve todos los vuelos disponibles, es decir,
	 * cuando existe un numero de plazas mayor que las solicitadas
	 * 
	 * @param plazas
	 * @return
	 */
	List<Vuelo> findVuelosDisponibles(int plazas);
	
	/**
	 * Método que devuelve todos los vuelos de una compañía
	 * @param company
	 * @return
	 */
	List<Vuelo> findVuelosCompany(String company);
	
	/**
	 * Método para actualizar un registro de Vuelo
	 * @param id
	 * @param plazas
	 */
	void updateVuelo(int id, int plazas);
	
}
