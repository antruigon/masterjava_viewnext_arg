package com.cursojava.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursojava.dao.ReservasDao;
import com.cursojava.model.HotelReserva;
import com.cursojava.model.Reserva;
import com.cursojava.model.VueloReserva;

@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	RestTemplate template;
	
	private String urlHoteles = "http://localhost:8080/";
	private String urlVuelos = "http://localhost:8081/";
	
	@Autowired
	ReservasDao dao;
	
	@Override
	public List<Reserva> findReservas() {
		return dao.findAll();
	}

	@Override
	public List<Reserva> findReservasHotel(int idHotel) {
		return dao.findByIdHotel(idHotel);
	}

	@Override
	public List<Reserva> findReservasHotelNombre(String nombre) {
		Integer hotelId = this.getIdHotelByNombre(nombre);
		return dao.findByIdHotel(hotelId);
	}

	@Override
	public List<Reserva> findReservasVuelo(int idVuelo) {
		return dao.findByIdVuelo(idVuelo);
	}

	@Override
	public List<Reserva> findReservasClienteDni(String dni) {
		return dao.findByDni(dni);
	}

	/**
	 * Además de añadir el registro Reserva a la base de datos, se encarga de hacer una petición
	 * al microservicio Vuelos para actualizar sus registros, decrementando el numero de plazas del
	 * vuelo en función del numero de personas de la reserva.
	 * 
	 * Se comprueba antes de hacer la reserva y actualizar vuelos tanto que el hotel está disponible
	 * como que hay suficientes plazas para el vuelo.
	 * 
	 * (Haciendo estas comprobaciones aquí, en el microservicio Vuelos, en el endpoint del PUT no habría
	 * que hacerla, pero se ha dejado puesta por si se llegara a lanzar el PUT de forma independiente y no
	 * desde el microservicio en el que nos encontramos, Reservas.)
	 */
	@Override
	public void postReserva(Reserva reserva) {
		Boolean hotelDisponible = getHotelById(reserva.getIdHotel()).getDisponible();
		Integer plazasDisponibles = getVueloById(reserva.getIdVuelo()).getPlazas();
		
		if(hotelDisponible && plazasDisponibles >= reserva.getPersonasReserva()) {			
			dao.save(reserva);
			template.put(urlVuelos+"vuelos/{id}/{plazas}", null, reserva.getIdVuelo(), reserva.getPersonasReserva());
		}
	}
	
	
	/**
	 * Método auxiliar que utiliza la clase auxiliar HotelReserva para obtener
	 * un hotel del microservicio Hoteles y que devuelve el id del hotel pasándole el nombre del mismo.
	 * 
	 * Este método facilita la lectura de código para el método público findReservasHotelNombre
	 * 
	 * @see HotelReserva.java
	 * @param nombre
	 * @return
	 */
	private Integer getIdHotelByNombre(String nombre) {
		String urlQuery = urlHoteles+"hoteles";
		List<HotelReserva> hoteles = Arrays.asList(template.getForObject(urlQuery, HotelReserva[].class));
		
		return hoteles.stream()
				.filter( h -> h.getNombre().equals(nombre))
				.findAny().orElse(null).getId();
	}
	
	
	/**
	 * Método auxiliar que utiliza la clase auxiliar VueloReserva para obtener un 
	 * vuelo del microservicio Vuelos y devuelve un vuelo en función al id pasado 
	 * como parámetro
	 * 
	 * @param id
	 * @return
	 */
	private VueloReserva getVueloById(int id) {
		String urlQuery = urlVuelos+"vuelos";
		List<VueloReserva> vuelos = Arrays.asList(template.getForObject(urlQuery, VueloReserva[].class));
		
		return vuelos.stream()
				.filter( v -> v.getId().equals(id))
				.findAny().orElse(null);
		
	}
	
	/**
	 * Método auxiliar que utiliza la clase auxiliar HotelReserva para obtener un 
	 * vuelo del microservicio Hoteles y devuelve un hotel en función al id pasado 
	 * como parámetro
	 * 
	 * @param id
	 * @return
	 */
	private HotelReserva getHotelById(int id) {
		String urlQuery = urlHoteles+"hoteles";
		List<HotelReserva> hoteles = Arrays.asList(template.getForObject(urlQuery, HotelReserva[].class));
		
		return hoteles.stream()
				.filter( h -> h.getId().equals(id))
				.findAny().orElse(null);
	}
	
}
