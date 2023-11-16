<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.curso.service.ServiceProductos"%>
<%@page import="com.curso.model.Producto"%>
<%@page import="java.util.List"%>
<%
String seccion = request.getParameter("seccion");
ServiceProductos sP = new ServiceProductos();
List<Producto> listaProductosSeccion = sP.buscarTodo();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Busqueda de todos los productos</title>
</head>
<body>


<h1> Ha seleccionado: <%=seccion %></h1> <a href="index.html">Volver a home</a>

<% for(Producto p: listaProductosSeccion) { %>
	<h3> <%=p.getNombre() %> </h3>
	<h4> Seccion: <%=p.getSeccion() %> </h4>
	<h4> Precio: <%=p.getPrecio() %> </h4>
	<h5> Stock: <%=p.getStock() %> </h5>
	<hr>
	<%} %>

</body>
</html>