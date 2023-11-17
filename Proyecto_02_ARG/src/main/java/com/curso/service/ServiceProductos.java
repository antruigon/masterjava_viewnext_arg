package com.curso.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.curso.model.Producto;

public class ServiceProductos {

	public void iniciar() {
		Producto p1 = new Producto("iPhone 8", "Electronica", 500.0, 30);
		Producto p2 = new Producto("Microondas", "Electrodomestico", 50.50, 10);
		Producto p3 = new Producto("Camiseta", "Ropa", 20.0, 40);
		Producto p4 = new Producto("iPhone 15", "Electronica", 1500.0, 5);
		Producto p5 = new Producto("Frigorifico", "Electrodomestico", 300.0, 7);
		Producto p6 = new Producto("Pantalón", "Ropa", 20.0, 40);

		List<Producto> listaProductos = new ArrayList<>();
		Collections.addAll(listaProductos, p1, p2, p3, p4, p5, p6);
		
		Producto.setListaProductos(listaProductos);
	}

	public List<Producto> buscarTodo() {
		return Producto.getListaProductos();
	}
	
	public List<Producto> buscarPorSeccion(String seccion){
		List<Producto> res = Producto.getListaProductos().stream()
			.filter(x -> seccion.equals(x.getSeccion()))
			.collect(Collectors.toList());
	
		return res;
	}
	
	public void añadirProducto(String nombre, String seccion, Double precio, int stock) {
		Producto p = new Producto(nombre, seccion, precio, stock);
		
		List<Producto> listaProductos = Producto.getListaProductos();
		listaProductos.add(p);
		
		Producto.setListaProductos(listaProductos);
	}
	
	public void eliminarProducto(String nombre) {
		List<Producto> nuevaLista = Producto.getListaProductos().stream()
				.filter(x -> !x.getNombre().equals(nombre))
				.collect(Collectors.toList());
		
		Producto.setListaProductos(nuevaLista);
	}
	
	public void modificarProducto(String nombre, String seccion, Double precio, int stock, String id) {
		List<Producto> nuevaLista = Producto.getListaProductos().stream()
				.filter(x -> !(x.getId().equals(id)))
				.collect(Collectors.toList());
		
		Producto p = new Producto(nombre, seccion, precio, stock);
		nuevaLista.add(p);
		
		Producto.setListaProductos(nuevaLista);
	}
}
