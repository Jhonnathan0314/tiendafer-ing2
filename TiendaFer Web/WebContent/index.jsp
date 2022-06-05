<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Document</title>
    <link rel="stylesheet" href="css/login.css">
</head>

<body class="background">

    <form action="Servlet">
        <img class="logoTienda" src="imagenes/logoTienda.png" alt="">

        <div class="dataBox">
            <h1 class="textField">Ingrese el nombre de usuario</h1>
            <input type="text" class="dataField" name="txtUser">

            <h1 class="textField">Ingrese la contraseña</h1>
            <input type="password" class="dataField" name="txtPassword">

            <input type="submit" class="buttom" value="Ingresar" name="menu">
        </div>
    </form>

</body>
</html>