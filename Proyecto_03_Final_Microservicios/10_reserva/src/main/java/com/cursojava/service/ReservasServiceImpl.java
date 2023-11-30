package com.cursojava.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursojava.dao.ReservasDao;
import com.cursojava.model.HotelReserva;
import com.cursojava.model.PromocionReserva;
import com.cursojava.model.Reserva;
import com.cursojava.model.VueloReserva;

@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	RestTemplate template;
	
	private String urlHoteles = "http://localhost:8080/";
	private String urlVuelos = "http://localhost:8081/";
	private String urlPromociones = "http://localhost:8083/";
	
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
		HotelReserva hotel = this.getHotelById(reserva.getIdHotel());
		VueloReserva vuelo = this.getVueloById(reserva.getIdVuelo());
		
		Boolean hotelDisponible = hotel.getDisponible();
		Integer plazasDisponibles = vuelo.getPlazas();
		
		Integer personasReserva = reserva.getPersonasReserva(); 
		Double precio = calcularPrecio(hotel, vuelo, null, personasReserva);
		
		if(hotelDisponible && plazasDisponibles >= personasReserva) {			
			reserva.setPrecioTotal(precio);
			dao.save(reserva);
			template.put(urlVuelos+"vuelos/{id}/{plazas}", null, reserva.getIdVuelo(), reserva.getPersonasReserva());
		}
	}
	
	/**
	 * Añade el registro Reserva a la base de datos con una promoción aplicada.
	 * 
	 * Además, actualiza en el microservicio de promoción el registro de la promoción utilizada,
	 * poniendola en no disponible, ya que se consideran para el ejercicio que las
	 * promociones serán de un solo uso.
	 */
	@Override
	public void postReservaPromocion(Reserva reserva, int id) {
		HotelReserva hotel = this.getHotelById(reserva.getIdHotel());
		VueloReserva vuelo = this.getVueloById(reserva.getIdVuelo());
		
		Boolean hotelDisponible = hotel.getDisponible();
		Integer plazasDisponibles = vuelo.getPlazas();
		
		Integer personasReserva = reserva.getPersonasReserva(); 
		Double precio = calcularPrecio(hotel, vuelo, Optional.of(id), personasReserva);
		
			
		if(hotelDisponible && plazasDisponibles >= personasReserva) {			
			reserva.setPrecioTotal(precio);
			dao.save(reserva);
			template.put(urlVuelos+"vuelos/{id}/{plazas}", null, reserva.getIdVuelo(), reserva.getPersonasReserva());
			template.put(urlPromociones+"promociones/estado/{id}", null, id);
		}
	}
	
	/**
	 * Método auxiliar que sirve para calcular el precio total de una reserva tanto si hay promoción
	 * como si no la hay
	 * 
	 * @param hotel
	 * @param vuelo
	 * @param idPromocion
	 * @param personasReserva
	 * @return
	 */
	private Double calcularPrecio(HotelReserva hotel, VueloReserva vuelo, Optional<Integer> idPromocion, int personasReserva) {
		PromocionReserva promocion = this.getPromocionById(idPromocion.orElse(null));
		
		Double precioTotalHotel = hotel.getPrecio() * personasReserva;
		Double precioTotalVuelo = vuelo.getPrecio() * personasReserva;
		
		if(promocion != null && promocion.getActiva()) {
			if(promocion.getHotel()) {
				precioTotalHotel = hotel.getPrecio() - ((hotel.getPrecio() * promocion.getPorcentaje())/100);
			}
			
			if(promocion.getVuelo()) {
				precioTotalVuelo = vuelo.getPrecio() - ((vuelo.getPrecio() * promocion.getPorcentaje())/100);
			}
		}
		
		return precioTotalHotel + precioTotalVuelo;
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
	
	/**
	 * Método auxiliar que utiliza la clase auxiliar PromocionReserva para obtener
	 * una promoción del microservicio Promociones y devuelve una promoción en función
	 * del id pasado como parámetro
	 * 
	 * @param id
	 * @return
	 */
	private PromocionReserva getPromocionById(int id) {
		String urlQuery = urlPromociones+"promociones";
		List<PromocionReserva> promociones = Arrays.asList(template.getForObject(urlQuery, PromocionReserva[].class));
		
		return promociones.stream()
				.filter( p -> p.getId().equals(id))
				.findAny().orElse(null);
	}

}
