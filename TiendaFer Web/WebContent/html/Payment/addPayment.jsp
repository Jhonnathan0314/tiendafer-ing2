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
                <div class="bill">
                    <h3 class="attributeBill">Tienda Fer</h3>

                    <div class="clienteAttributesBox" style="margin-left: 25%; margin-bottom: 2%;">
                        <select class="selectClient" name="dniCliente">
                            <option selected>Seleccione cliente</option>
                            <c:forEach var="client" items="${clients}">
	                            <option value="${client.getDni() }">${client.getName() }</option>
                            </c:forEach>
                        </select>
                        <button type="submit" name="action" value="BuscarCliente" class="buscarButtom">Buscar</button>

                        <h3 class="attributeBill">Cedula cliente: ${clienteB.getDni() }</h3>
                        <h3 class="attributeBill">Nombre cliente: ${clienteB.getName() }</h3>
                        
                    </div>

					<button type="submit" name="action" value="BuscarFacturas" class="buscarButtom" style="margin-left: 39%; margin-top: 2%; width: 150px;">Facturas pendientes</button>
                    <br>
                    <h3 class="attributeBill">Efectivo</h3>
                    <input type="number" name="txtEfectivo" class="efectivoBar">

                    <table class="billTable" id="tablaprueba">
                        <thead class="thead">
                            <tr>
                                <th>Codigo</th>
                                <th>Fecha</th>
                                <th>Valor total</th>
                                <th>Cliente</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="bill" items="${bills }">
	                            <tr>
	                                <th>${bill.getBillNumber() }</th>
	                                <th>${bill.getDate() }</th>
	                                <th>${bill.getSaleValue() }</th>
	                                <th>${bill.getClient().getName() }</th>
	                            </tr>
                        	</c:forEach>
                        </tbody>
                    </table>

                    <h1 class="valorTotal">Deuda total: ${deudaTotal }</h1>
                    <h1 class="valorTotal">Cambio: ${cambio }</h1>

                    <input type="submit" class="addButtom" value="Pagar" name="action">

                    <input type="submit" class="cancelButtom" value="Cancelar" name="action">

                </div>
    </form>

</body>
</html>