package com.cursojava.model;

import java.time.LocalDateTime;

public class VueloReserva {

	private Integer id;
	private String compañia;
	private LocalDateTime fecha;
	private Double precio;
	private Integer plazas;
	
	public VueloReserva() {
		super();
	}
	
	public VueloReserva(Integer id, String compañia, LocalDateTime fecha, Double precio, Integer plazas) {
		super();
		this.id = id;
		this.compañia = compañia;
		this.fecha = fecha;
		this.precio = precio;
		this.plazas = plazas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	
}
