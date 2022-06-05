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

		<form action="Servlet?menu=Bill" method="post" class="container">
                <a href="Servlet?menu=Bill&action=searchAll">
		            <img src="imagenes/volver.png" alt="" class="volver">
		        </a>
                
                <h1 class="titulo">Facturas</h1>
                <table class="peTable">
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Pedido</th>
                            <th>Cantidad pedida</th>
                            <th>Cantidad recibida</th>
                            <th>Valor unitario</th>
                            <th>Valor total</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="orderDetail" items="${orderDetails }">
	                        <tr class="scroll">
	                            <th>${orderDetail.getProduct().getName() }</th>
	                            <th>${orderDetail.getOrder().getOrderCode() }</th>
	                            <th>${orderDetail.getOrderedAmount() }</th>
	                            <th>${orderDetail.getReceivedAmount() }</th>
	                            <th>${orderDetail.getUnitValue() }</th>
	                            <th>${orderDetail.getTotalValue() }</th>
	                        </tr>
	                    </c:forEach>
                    </tbody>
                </table>
		</form>
</body>
</html>