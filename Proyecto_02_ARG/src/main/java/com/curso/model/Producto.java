package com.curso.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Producto {

	private String nombre;
	private String seccion;
	private Double precio;
	private int stock;
	private static List<Producto> listaProductos = new ArrayList<>();
	private static Set<String> secciones = new HashSet<String>();
	
	public Producto(String nombre, String seccion, Double precio, int stock) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;

		secciones.add(seccion);
	}
	
	public Producto(String nombre, String seccion, Double precio, int stock, List<Producto> lista) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;

		listaProductos = lista;
		secciones.add(seccion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public static List<Producto> getListaProductos() {
		return listaProductos;
	}

	public static void setListaProductos(List<Producto> lista) {
		listaProductos = lista;
	}

	public static Set<String> getSecciones() {
		return secciones;
	}

	public static void setSecciones(Set<String> secciones) {
		Producto.secciones = secciones;
	}
	
}
