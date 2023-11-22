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
<title>Eliminar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://kit.fontawesome.com/59eb7f2846.js" crossorigin="anonymous"></script>
</head>
<body>


	<container
		class="justify-content-center text-center align-items-center">
	<div class="row justify-content-center">
		<a href="index.jsp">Volver a home</a>
		<h1>Selecciona un producto para eliminarlo</h1>

		<%
		ServiceProductos sP = new ServiceProductos();
		List<Producto> listaProductos = sP.buscarTodo();
		%>

		<form action="Eliminar" method="POST">
			<select name="producto">
				<%
				for (Producto p : listaProductos) {
				%>
				<option value="<%=p.getId()%>">
					<%=p.getNombre()%>
				</option>
				<%
				}
				%>
			</select> <input type="submit">
		</form>
	</div>
	</container>

</body>
</html>