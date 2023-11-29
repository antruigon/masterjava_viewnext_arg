package com.cursojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.model.Reserva;
import com.cursojava.service.ReservasService;

@RestController
public class ReservasController {

	@Autowired
	ReservasService service;
	
	/**
	 * Endpoint que devuelve la lista con todas las reservas
	 * 
	 * @url http://localhost:8082/reservas
	 * @return
	 */
	@GetMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findReservas(){
		return service.findReservas();
	}
	
	/**
	 * Endpoint que devuelve las reservas para un hotel por su id
	 * 
	 * @url http://localhost:8082/reservas/hotel/{id}
	 * @param id
	 * @return
	 */
	@GetMapping(value = "reservas/hotel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findReservasHotel(@PathVariable int id){
		return service.findReservasHotel(id);
	}
	
	/**
	 * Enpoint que devuelve las reservas para un vuelo dado por su id
	 * 
	 * @url http://localhost:8082/reservas/vuelo/{id}
	 * @param id
	 * @return
	 */
	@GetMapping(value = "reservas/vuelo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findReservasVuelo(@PathVariable int id){
		return service.findReservasVuelo(id);
	}
	
	/**
	 * Endpoint que devuelve las reservas de un cliente por su dni
	 * 
	 * @url http://localhost:8082/reservas/dni/{dni}
	 * @param dni
	 * @return
	 */
	@GetMapping(value = "reservas/dni/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findReservasClienteDni(@PathVariable String dni){
		return service.findReservasClienteDni(dni);
	}
	
	/**
	 * Endpoint que devuelve las reservas de un hotel dado su nombre
	 * 
	 * @url http://localhost:8082/reservas/hotel/nombre/{nombre}
	 * @param nombre
	 * @return
	 */
	@GetMapping(value = "reservas/hotel/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findReservasHotelNombre(@PathVariable String nombre){
		return service.findReservasHotelNombre(nombre);
	}
	
	/**
	 * Endpoint para añadir una reserva
	 * 
	 * @url http://localhost:8082/reservas
	 * @param reserva
	 */
	@PostMapping(value = "reservas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void findReservasHotelNombre(@RequestBody Reserva reserva){
		service.postReserva(reserva);
	}
	
}
