package com.cursojava.dto;

/**
 * Clase auxiliar que usaremos para traernos los recursos disponibles
 * mediante el microservicio de Hoteles.
 * 
 * En esta clase tenemos los mismos atributos que en la clase de Hotel.java
 * disponible en el microservicio mencionado
 */

public class HotelDto {

	private Integer id;
	private String nombre;
	private String categoria;
	private Double precio;
	private Boolean disponible;
	
	public HotelDto() {
		super();
	}

	public HotelDto(Integer id, String nombre, String categoria, Double precio, Boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
}
