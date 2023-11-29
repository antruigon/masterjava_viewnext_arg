package com.cursojava.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursojava.dao.ReservasDao;
import com.cursojava.model.HotelReserva;
import com.cursojava.model.Reserva;

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
	 */
	@Override
	public void postReserva(Reserva reserva) {
		dao.save(reserva);
		template.put(urlVuelos+"vuelos/{id}/{plazas}", null, reserva.getIdVuelo(), reserva.getPersonasReserva());
	}
	
	
	/**
	 * Método auxiliar que se encarga de utilizar la clase auxiliar HotelReserva para obtener
	 * un hotel del microservicios Hoteles y que devuelve el id del hotel pasándole el nombre del mismo.
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
	
}
