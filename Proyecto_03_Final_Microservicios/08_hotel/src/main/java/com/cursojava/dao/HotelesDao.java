package com.cursojava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer> {

	/**
	 * Método que busca en la base de datos los registros con el campo 
	 * disponible == true
	 * @return
	 */
	List<Hotel> findByDisponibleTrue();
	
	/**
	 * Método que busca en la base de datos en función del nombre del hotel
	 * @param nombre
	 * @return
	 */
	Hotel findByNombre(String nombre);
	
	/**
	 * Método que busca en la base de datos en función de la categoría
	 * @param categoria
	 * @return
	 */
	List<Hotel> findByCategoria(String categoria);
	
}
