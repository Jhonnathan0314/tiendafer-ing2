<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/Producto/addProducto.css">
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
    
    	<form action="Servlet?menu=Section" method="post" class="container">
        	<a href="Servlet?menu=Section&action= ">
		        <img src="imagenes/volver.png" alt="" class="volver">
		    </a>
        	
        	<h3 class="titulo">Seccion</h3>
        
            <h3 class="textField">Ingrese el nombre de la nueva seccion</h3>
            <input type="text" class="dataField" name="txtNombreCrearSeccion">

            <input type="submit" class="addButtom" value="Registrar" name="action">

            <input type="submit" class="cancelButtom" value="Cancelar" name="action">
    	</form>
</body>
</html>