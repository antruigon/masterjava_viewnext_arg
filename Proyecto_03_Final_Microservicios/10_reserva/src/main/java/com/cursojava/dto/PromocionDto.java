package com.cursojava.dto;

import jakarta.persistence.Column;

public class PromocionDto {

	private Integer id;
	private Boolean hotel;
	private Boolean vuelo;
	private Integer porcentaje;
	@Column(columnDefinition = "boolean default true")
	private Boolean activa;
	
	public PromocionDto() {
		super();
	}

	public PromocionDto(Integer id, Boolean hotel, Boolean vuelo, Integer porcentaje, Boolean activa) {
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
