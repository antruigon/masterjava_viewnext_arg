package com.cursojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.model.Hotel;
import com.cursojava.service.HotelesService;

@RestController
public class HotelesController {

	@Autowired
	HotelesService service;
	
	/**
	 * Devuelve la lista de hoteles disponibles o todos, indicandoselos
	 * con el parametro disponible
	 * 
	 * @url http://localhost:8080/hoteles
	 * @param disponible
	 * @return
	 */
	@GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> findHoteles(@RequestParam(required = false) String disponible){
		if(Boolean.parseBoolean(disponible)) {
			return service.findHotelesDisponibles();
		} else {			
			return service.findAllHoteles();
		}
	}
	
	/**
	 * Devuelve un hotel pasandole el nombre
	 * 
	 * @url http://localhost:8080/hoteles/nombre/{nombre}
	 * @param nombre
	 * @return
	 */
	@GetMapping(value = "hoteles/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotel findHotelesNombre(@PathVariable String nombre){
		return service.findHotelNombre(nombre);
	}
	
	/**
	 * Devuelve los hoteles de una categoría dada
	 * 
	 * @url http://localhost:8080/categoria/{categoria}
	 * @param categoria
	 * @return
	 */
	@GetMapping(value = "hoteles/categoria/{categoria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> findHotelesCategoria(@PathVariable String categoria){
		return service.findHotelCategoria(categoria);
	}
	
}
