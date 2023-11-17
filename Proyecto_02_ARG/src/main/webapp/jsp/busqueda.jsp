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
<title>Busqueda</title>
</head>
<body>

	<%
	ServiceProductos sP = new ServiceProductos();
	List<Producto> lista = sP.buscarTodo();
	Set<String> secciones = Producto.getSecciones();
	%>
	<a href="index.jsp">Volver a home</a>
	<h1>Selecciona una sección:</h1> 

	<form action="Buscador" method="POST">
		<select name="seccion">
			<%
			if (secciones != null) {
				for (String s : secciones) {
			%>
			<option value="<%=s%>">
				<%=s%>
			</option>
			<%
			}
			}
			%>
		</select>
		<input type="submit">
	</form>

</body>
</html>