package com.cursojava.service;

import java.util.List;

import com.cursojava.model.Reserva;

public interface ReservasService {

	/**
	 * Método que devuelve todas las reservas
	 * @return
	 */
	List<Reserva> findReservas();

	/**
	 * Método que devuelve todas las reservas de un hotel pasandole el id del hotel
	 * @param idHotel
	 * @return
	 */
	List<Reserva> findReservasHotel(int idHotel);

	/**
	 * Método que devuelve todas las reservas de un hotel pasandole el nombre del hotel
	 * @param nombre
	 * @return
	 */
	List<Reserva> findReservasHotelNombre(String nombre);

	/**
	 * Método que devuelve todas las reservas de un vuelo pasandole el id del vuelo
	 * @param idVuelo
	 * @return
	 */
	List<Reserva> findReservasVuelo(int idVuelo);

	
	/**
	 * Método que devuelve todas las reservas de un dni pasandole dicho dni
	 * @param dni
	 * @return
	 */
	List<Reserva> findReservasClienteDni(String dni);
	
	/**
	 * Método que se encarga de añadir un registro de Reserva a la base de datos
	 * @param reserva
	 */
	void postReserva(Reserva reserva);
	
	/**
	 *  Método que se encarga de añadir un registro de Reserva a la base de datos
	 *  aplicando una promocion dada su id
	 * 
	 * @param reserva
	 * @param id
	 */
	void postReservaPromocion(Reserva reserva, int id);

}
