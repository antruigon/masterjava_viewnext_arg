package com.cursojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.model.Promocion;
import com.cursojava.service.PromocionesService;

@RestController
public class PromocionesController {

	@Autowired
	PromocionesService service;
	
	/**
	 * Endpoint para obtener las promociones. Si no se le pasa parámetro devolvera 
	 * todas, y si se la pasa, en función de si es true o false devolverá sólo las activas
	 * o todas (respectivamente)
	 * 
	 * @param activa
	 * @return
	 */
	@GetMapping(value = "promociones", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Promocion> findPromociones(@RequestParam(required = false) String activa){
		if(Boolean.parseBoolean(activa)) {
			return service.findPromocionesActivas();
		} else {			
			return service.findAllPromociones();
		}
	}
	
	
	/**
	 * Endpoint para devolver una promocion por la id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "promociones/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Promocion findPromocionesById(@PathVariable int id){
		return service.findPromocionById(id);
	}
	
	/**
	 * Endpoint para añadir una promoción
	 * @param promocion
	 */
	@PostMapping(value = "promociones", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postPromociones(@RequestBody Promocion promocion){
		service.postPromocion(promocion);
	}
	
	
	/**
	 * Endpoint para actualizar una promoción
	 * 
	 * @param id
	 */
	@PutMapping(value = "promociones/estado/{id}")
	public void putPromociones(@PathVariable int id) {
		service.putPromocion(id);
	}
	
}
