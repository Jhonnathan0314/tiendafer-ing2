<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/Factura/addPedido.css">
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

		<form action="Servlet?menu=Payment" method="post" class="container">
                <h1 class="titulo">Pagos</h1>

                <table class="peTable">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Cliente</th>
                            <th>Saldo total</th>
                            <th>Saldo cancelado</th>
                            <th>Cambio</th>
                            <th>Factura</th>
                        </tr>
                    </thead>
                    <tbody>
                    	
                        <tr class="scroll">
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                        </tr>
                    </tbody>
                </table>

				<a href="Servlet?action=addPayment">
	                <input type="button" class="buttomCrud" value="Generar">
				</a>

				<a href="Servlet?action=searchPayment">
	                <input type="button" class="buttomCrud" value="Consultar">
				</a>
    	</form>
</body>
</html>