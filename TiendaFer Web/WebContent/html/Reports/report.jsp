<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/Producto/producto.css">
</head>

<body class="background">
    <form action="">

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

        <div>
            <div class="container">
                <h1 class="titulo">Reportes</h1>

                <table class="peTable">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Ganancias</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="scroll">
                            <th class="textoResultados">-</th>
                            <th class="textoResultados">-</th>
                        </tr>
                    </tbody>
                </table>

                <input type="submit" class="buttomCrud" value="Diario">
                
                <input type="submit" class="buttomCrud" value="Mensual">

            </div>
        </div>

    </form>
</body>
</html>