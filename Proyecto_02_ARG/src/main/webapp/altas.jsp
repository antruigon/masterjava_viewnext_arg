<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Dar de alta un producto: </h1> <a href="index.html">Volver a home</a>

<form action="Alta" method="POST">
	Nombre del producto: <input type="text" name="nombre"> <br>
	Seccion: <input type="text" name="seccion"> <br>
	Precio: <input type="number" name="precio"> <br>
	Stock: <input type="text" name="stock"> <br> <br>
	<input type="submit">
</form>

</body>
</html>