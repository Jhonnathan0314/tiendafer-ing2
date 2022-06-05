<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/Producto/updateProducto.css">
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

			<form action="Servlet?menu=Provider" method="post" class="container">
                <h1 class="titulo">Proveedor</h1>

				<div class="select">
	                <select class="selectText" name="nitProveedor">
		        		<option selected> PROVEEDOR ACTUAL </option>
		        		<c:forEach var="provider" items="${providers }">
			            	<option value="${provider.getNit() }">${provider.getSupplierName() }</option>
		        		</c:forEach>
		        	</select>
				</div>
                <h3 class="textField">Digite el nuevo nombre del proveedor</h3>
                <input type="text" class="dataField" name="txtNewSupplierName">

                <h3 class="textField">Digite el nombre del nuevo vendedor</h3>
                <input type="text" class="dataField" name="txtNewSellerName">

                <input type="submit" class="addButtom" value="Guardar" name="action">
                <input type="submit" class="inactiveButtom" value="Inactivar" name="action">
                <input type="submit" class="cancelButtom" value="Cancelar" name="action">
                
	    	</form>
</body>
</html>