package com.cursojava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cliente;
	private String dni;
	private Integer idHotel;
	private Integer idVuelo;
	private Integer personasReserva;
	private Double precioTotal;
	
	public Reserva() {
		super();
	}

	public Reserva(Integer id, String cliente, String dni, Integer idHotel, Integer idVuelo, Integer personasReserva) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.dni = dni;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.personasReserva = personasReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Integer getPersonasReserva() {
		return personasReserva;
	}

	public void setPersonasReserva(Integer personasReserva) {
		this.personasReserva = personasReserva;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
