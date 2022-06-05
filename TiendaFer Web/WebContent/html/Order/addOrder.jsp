<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>Document</title>
<link rel="stylesheet" href="css/Factura/addPedido.css">
<style type="text/css">
	@media print{
		.buttonContainer, .productBox, .addButtom, .cancelButtom{
			display: none;
		}
	}
</style>
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

	<form action="Servlet?menu=Order" method="post">
            <div class="container">
                <div class="bill">
                    <h3 class="attributeBill">Tienda Fer</h3>

                    <div class="clienteAttributesBox">
                        <select class="selectClient" name="nitProvider">
                            <option selected>Seleccione proveedor</option>
                            <c:forEach var="provider" items="${providers}">
	                            <option value="${provider.getNit() }">${provider.getSupplierName() }</option>
                            </c:forEach>
                        </select>
                        
                        <button type="submit" name="action" value="BuscarProveedor" class="buscarButtom">Buscar</button>
                        
                        <h3 class="attributeBill">${proveedorB.getNit() }</h3>
                        <h3 class="attributeBill">${proveedorB.getSupplierName() }</h3>
                        
                    </div>

                    <div class="facturaAttributesBox">
                        <h3 class="attributeBill">Codigo Pedido: #####</h3>
                        <%
                        String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
                        %>
                        <h3 class="attributeBill">Fecha: <%=timeStamp.toString() %></h3>
                    </div>

                    <div class="productBox">
                        <br><br><br><br><br><br><br>
                        <select class="selectClient" name="productCode">
                            <option selected>Seleccione producto</option>
                            <c:forEach var="product" items="${products }">
	                            <option value="${product.getCode() }">${product.getName() }</option>
                            </c:forEach>
                        </select>

						<button type="submit" name="action" value="BuscarProducto" class="buscarButtom">Buscar</button>

                        <div class="dataProductContainer">
                            <div class="productMiniContainLeft">
                                <label class="inputName">Nombre:</label>
                                <input type="text" name="txtProductName" value="${productoB.getName() }" placeholder="Nombre"
                                    class="productInput">
                                <input type="number" name="txtValorUnitario" value="${productoB.getValue() }" placeholder="Nombre"
                                    class="productInput">
                                <label class="inputName">Valor c/u:</label>
                                <input type="number" name="txtStock" value="${productoB.getQuantityAvailable() }" placeholder="Stock disponible"
                                    class="productInput">
                                <label class="inputName">Stock:</label>
                            </div>
                            <div class="productMiniContainRight">
                                <label class="inputName">Cant. pedida:</label>
                                <input type="number" name="txtCantidadPedida" value="1" placeholder="Cantidad pedida"
                                    class="productInput">
                                <input type="number" name="txtCantidadRecibida" value="1" placeholder="Cantidad recibida"
                                    class="productInput">
                                <label class="inputName">Cant. recibida:</label>
                            </div>
                        </div>

                        <button type="submit" name="action" value="Agregar" class="addProduct">Añadir producto</button>
                    </div>

                    <table class="billTable" id="tablaprueba">
                        <thead class="thead">
                            <tr>
                                <th>Nombre producto</th>
                                <th>Cantidad pedida</th>
                                <th>Cantidad recibida</th>
                                <th>Valor unitario</th>
                                <th>Monto</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="compra" items="${compras }">
                            	<tr>
	                                <th>${compra.getProduct().getName() }</th>
	                                <th>${compra.getOrderedAmount() }</th>
	                                <th>${compra.getReceivedAmount() }</th>
	                                <th>${compra.getUnitValue() }</th>
	                                <th>${compra.getTotalValue() }</th>
	                                <th>
	                                    <div class="deleteButtom">
	                                        <a class="textDeleteButtom" href="Servlet?menu=Order&action=Delete&idP=${venta.getProduct().getCode() }">Delete</a>
	                                    </div>
	                                </th>
                            	</tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <h1 class="valorTotal">Valor total: ${totalPagar }</h1>

                    <input type="submit" class="addButtom" value="Generar" name="action" onclick="print()">

                    <input type="submit" class="cancelButtom" value="Cancelar" name="action">
                </div>
            </div>
    </form>
</body>
</html>