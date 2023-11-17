package com.curso.controller;

import java.io.IOException;
import java.util.List;

import com.curso.model.Producto;
import com.curso.service.ServiceProductos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buscador
 */
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter("seccion");	
		
		request.setAttribute("seccion", seccion);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/busquedaseccion.jsp");
		dispatcher.include(request, response);
		
	}

}
