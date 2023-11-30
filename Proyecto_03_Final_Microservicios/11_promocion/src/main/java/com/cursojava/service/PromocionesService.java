package com.cursojava.service;

import java.util.List;

import com.cursojava.model.Promocion;

public interface PromocionesService {

	/**
	 * Devuelve todas las promociones
	 * @return
	 */
	List<Promocion> findAllPromociones();
	
	/**
	 * Devuelve solo las promociones activas
	 * @return
	 */
	List<Promocion> findPromocionesActivas();
	
	
	/**
	 * Devuelve una promocion dada la id
	 * @param id
	 * @return
	 */
	Promocion findPromocionById(int id);
	
	/**
	 * Añade un registro Promocion a la base de datos
	 * @param promocion
	 */
	void postPromocion(Promocion promocion);
	
	/**
	 * Actualiza la promocion dada su id
	 * @param id
	 */
	void putPromocion(int id);
	
}
