<%@page import="com.tiendafer.modeldao.ProductDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tiendafer.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tiendafer.interfaces.ProductCRUD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/menu.css">
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
        
        <div class="container" id="div1">   
            <h1 class="avisos">Avisos</h1>
            <h1 class="productosEscasos">Productos escasos</h1>

            <table class="peTable">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <%
                ProductDAO productDAO = new ProductDAO();
                ArrayList<Product> products = new ArrayList<Product>();
                products = productDAO.searchScarceProducts();
                Iterator<Product> iterator = products.iterator();
                Product product = null;
                while(iterator.hasNext()){
                	product = iterator.next();
                %>
                <tbody>
                    <tr>
                        <th class="textoResultados"><%=product.getCode()%></th>
                        <th class="textoResultados"><%=product.getName()%></th>
                        <th class="textoResultados"><%=product.getQuantityAvailable()%></th>
                    </tr>
                    <%} %>
                </tbody>
            </table>
        </div>
    </form>
</body>
</html>