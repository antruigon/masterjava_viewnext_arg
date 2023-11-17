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

<%
	ServiceProductos sP = new ServiceProductos();
	List<Producto> listaProductos = Producto.getListaProductos();
	
	Producto producto = listaProductos.stream()
			.filter(x->x.getNombre().equals(request.getParameter("producto")))
			.findAny()
			.get();
	
	String id = producto.getId();
	request.setAttribute("id", id);
%>

<a href="index.jsp">Volver a home</a>
<h1>Dar de alta un producto: </h1>

<form action="Modificacion" method="POST">
	Nombre del producto: <input type="text" name="nombre"> <br>
	Seccion: <input type="text" name="seccion"> <br>
	Precio: <input type="number" name="precio"> <br>
	Stock: <input type="text" name="stock"> <br> <br>
	 <input type="hidden" name="id" value="<%=id%>">
	<input type="submit">
</form>

</body>
</html>