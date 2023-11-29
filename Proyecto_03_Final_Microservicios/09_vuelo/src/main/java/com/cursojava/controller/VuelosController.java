package com.cursojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.model.Vuelo;
import com.cursojava.service.VuelosService;

@RestController
public class VuelosController {

	@Autowired
	VuelosService service;
	
	/**
	 * Endpoint para obtener todos los vuelos
	 * 
	 * @url http://localhost:8081/vuelos
	 * @return
	 */
	@GetMapping(value = "vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> findVuelos(){
		return service.findAllVuelos();
	}
	
	/**
	 * Endpoint para obtener todos los vuelos disponibles en funcion
	 * de las plazas solicitadas
	 * 
	 * @url http://localhost:8081/vuelos/plazas/{plazas}
	 * @param plazas
	 * @return
	 */
	@GetMapping(value = "vuelos/plazas/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> findVuelosPlazas(@PathVariable int plazas){
		return service.findVuelosDisponibles(plazas);
	}
	
	/**
	 * Endpoint que devuelve todos los vuelos de una compañía
	 * 
	 * @url http://localhost:8081/vuelos/company/{company}
	 * @param company
	 * @return
	 */
	@GetMapping(value = "vuelos/company/{company}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> findVuelosCompany(@PathVariable String company){
		return service.findVuelosCompany(company);
	}
	
	/**
	 * Endpoint que actualiza un registro
	 * 
	 * @url http://localhost:8081/vuelos/{id}/{plazas}
	 * @param id
	 * @param plazas
	 */
	@PutMapping(value = "vuelos/{id}/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateVuelo(@PathVariable int id, @PathVariable int plazas){
		service.updateVuelo(id, plazas);
	}
}
