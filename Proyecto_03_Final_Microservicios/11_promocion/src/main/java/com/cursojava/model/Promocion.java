package com.cursojava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "promociones")
public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean hotel;
	private Boolean vuelo;
	private Integer porcentaje;
	@Column(columnDefinition = "boolean default true")
	private Boolean activa;
	
	public Promocion() {
		super();
	}

	public Promocion(Integer id, Boolean hotel, Boolean vuelo, Integer porcentaje, Boolean activa) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.porcentaje = porcentaje;
		this.activa = activa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Boolean getHotel() {
		return hotel;
	}

	public void setHotel(Boolean hotel) {
		this.hotel = hotel;
	}

	public Boolean getVuelo() {
		return vuelo;
	}

	public void setVuelo(Boolean vuelo) {
		this.vuelo = vuelo;
	}

	public Integer getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
	
}
