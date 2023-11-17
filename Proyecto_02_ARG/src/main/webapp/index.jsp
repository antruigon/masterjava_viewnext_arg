<%@page import="com.curso.service.ServiceProductos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.model.Producto"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<%
List<Producto> listaProductos = Producto.getListaProductos();
if(listaProductos.isEmpty()) {
	ServiceProductos sP = new ServiceProductos();
	sP.iniciar();
}
%>

<%
String mensaje = (String)request.getAttribute("mensaje");
if(mensaje != null){%>
	<h4 style="background-color: green;"> <%=mensaje %> </h4>
<%}%>

<h1>Página principal</h1>

<ul>
<li> <a href="busqueda.jsp">Búsquedas</a> </li>
<li> <a href="busquedanoseccion.jsp">Búsqueda (sin seccion)</a> </li>
<li> <a href="altas.jsp">Altas</a> </li>
<li> <a href="eliminar.jsp">Eliminación</a> </li>
<li> <a href="modificar.jsp">Modificación</a> </li>
</ul>


</body>
</html>