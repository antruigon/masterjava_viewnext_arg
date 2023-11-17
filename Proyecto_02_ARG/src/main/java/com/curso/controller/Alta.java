package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.curso.model.Producto;
import com.curso.service.ServiceProductos;

/**
 * Servlet implementation class Alta
 */
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Este método se encarga de la lógica para añadir un producto tras el envio del formulario
	 * @see ServiceProductos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String seccion = request.getParameter("seccion");
		Double precio = Double.valueOf(request.getParameter("precio"));
		Integer stock = Integer.valueOf(request.getParameter("stock"));
		
		ServiceProductos sP = new ServiceProductos();
		sP.añadirProducto(nombre, seccion, precio, stock);
		
		request.setAttribute("mensaje", "Se ha añadido correctamente el producto " + nombre);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/altas.jsp");
		dispatcher.forward(request, response);
		
	}

}
