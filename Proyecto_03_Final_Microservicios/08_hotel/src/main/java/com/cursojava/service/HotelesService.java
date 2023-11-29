package com.cursojava.service;

import java.util.List;

import com.cursojava.model.Hotel;

public interface HotelesService {
	
	/**
	 * Método que devuelve todos los hoteles
	 * @return
	 */
	List<Hotel> findAllHoteles();
	
	/**
	 * Método que devuelve todos los hoteles disponibles
	 * @return
	 */
	List<Hotel> findHotelesDisponibles();
	
	/**
	 * Método que devuelve un hotel segun su nombre
	 * @param nombre
	 * @return
	 */
	Hotel findHotelNombre(String nombre);
	
	/**
	 * Método que devuelve todos los hoteles de una categoria
	 * @param categoria
	 * @return
	 */
	List<Hotel> findHotelCategoria(String categoria);

}
