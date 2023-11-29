package com.cursojava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {

	/**
	 * Método que devuelve las reservas pasandole el id del hotel
	 * @param idHotel
	 * @return
	 */
	List<Reserva> findByIdHotel(int idHotel);
	
	/**
	 * Método que devuelve las reservas pasandole el id del vuelo
	 * @param idVuelo
	 * @return
	 */
	List<Reserva> findByIdVuelo(int idVuelo);
	
	/**
	 * Método que devuelve la lista de reservas de una persona pasandole el dni
	 * @param dni
	 * @return
	 */
	List<Reserva> findByDni(String dni);
	
}
