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
<title>Insert title here</title>
</head>
<body>

<a href="index.jsp">Volver a home</a>
<h1>Selecciona un producto para eliminarlo</h1> 
	
	<%
		ServiceProductos sP = new ServiceProductos();
		List<Producto> listaProductos = sP.buscarTodo();
		
	%>
	
	<form action="Eliminar" method="POST">
		<select name="producto">
			<% for(Producto p: listaProductos){ %>
				<option value="<%=p.getId()%>">
					<%=p.getNombre() %>
				</option>
			<%} %>
		</select>
		<input type="submit">
	</form>
	
</body>
</html>