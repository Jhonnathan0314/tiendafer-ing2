<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/menu.css">
</head>

<body class="background">
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

        <div class="container" id="div1">
        	<a href="Servlet?menu=Section&action= ">
	            <img src="imagenes/volver.png" alt="" class="volver">
	        </a>
        
            <h1 class="titulo">Secciones</h1>

            <table class="peTable">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Cantidad</th>
                            <th>Valor venta</th>
                            <th>Cambio</th>
                            <th>Seccion</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="product" items="${products }">
	                        <tr class="scroll">
	                            <th>${product.getCode() }</th>
			                    <th>${product.getName() }</th>
			                    <th>${product.getQuantityAvailable() }</th>
			                    <th>${product.getValue() }</th>
			                    <th>${product.getChange() }</th>
			                    <th>${product.getSection().getName() }</th>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
        </div>
</body>
</html>