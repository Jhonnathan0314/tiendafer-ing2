<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/Producto/producto.css">
</head>

<body class="background">
	<form action="Servlet" method="post">
        <div class="buttonContainer">
            <a href="Servlet?menu=Home">    
                <img src="imagenes/logoTienda.png" alt="" class="logo" name="action">
            </a>

            <a href="Servlet?menu=Section&action= ">
                <input type="button" class="menuButtom" value="Secciones">
            </a>

            <a href="Servlet?menu=Product&action=searchAll">
                <input type="button" class="menuButtom" value="Productos">
            </a>

            <a href="Servlet?menu=Provider&action=searchAll">
                <input type="button" class="menuButtom" value="Proveedores">
            </a>

            <a href="Servlet?menu=Order&action=searchAll">
                <input type="button" class="menuButtom" value="Pedidos">
            </a>

            <a href="Servlet?menu=Client&action=searchAll">
                <input type="button" class="menuButtom" value="Clientes">
            </a>

            <a href="Servlet?menu=Bill&action=searchAll">
                <input type="button" class="menuButtom" value="Facturas">
            </a>

            <a href="Servlet?menu=Payment&action= ">
                <input type="button" class="menuButtom" value="Pagos">
            </a>

            <a href="Servlet?menu=Report">
                <input type="button" class="menuButtom" value="Reportes">
            </a>
        </div>
	</form>
	
	<form action="Servlet?menu=Client" method="post">
            <div class="container">
                <h1 class="titulo">Clientes</h1>

                <table class="peTable">
                    <thead>
                        <tr>
                            <th>Cedula</th>
                            <th>Nombre</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="clients" items="${clients }">
	                        <tr class="scroll">
	                            <th>${clients.getDni() }</th>
	                            <th>${clients.getName() }</th>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>

               	<input type="submit" class="buttomCrud" name="action" value="Crear">

                <input type="submit" class="buttomCrud" name="action" value="Consultar">

                <input type="submit" class="buttomCrud" name="action" value="Modificar">

            </div>
    </form>
</body>
</html>