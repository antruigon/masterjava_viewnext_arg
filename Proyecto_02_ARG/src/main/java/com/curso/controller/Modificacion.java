package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.curso.service.ServiceProductos;

/**
 * Servlet implementation class Modificacion
 */
public class Modificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String seccion = request.getParameter("seccion");
		Double precio = Double.valueOf(request.getParameter("precio"));
		Integer stock = Integer.valueOf(request.getParameter("stock"));
		
		String id = request.getParameter("id");
		
		ServiceProductos sP = new ServiceProductos();
		sP.modificarProducto(nombre, seccion, precio, stock, id);
		
		request.setAttribute("mensaje", "Producto modificado correctamente");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.include(request, response);
		
	}

}
