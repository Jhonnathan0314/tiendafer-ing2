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

        <div class="container">
            <h1 class="titulo">Secciones</h1>

			<a href="Servlet?menu=Section&action=searchSection&secCode=1">
	            <div class="bebidasButtom">
	                <div class="whiteSquare">
	                 	<label class="seccionText">Bebidas</label>
	                </div>
	            </div>
			</a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=2">
                <div class="abarrotesButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Abarrotes</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=3">
                <div class="panaderiaButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Panaderia</label>
                    </div>
                </div>
            </a>
            
            <a href="Servlet?menu=Section&action=searchSection&secCode=4">
                <div class="frutasButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Frutas</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=5">
                <div class="golosinasButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Golosinas</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=6">
                <div class="medicamentosButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Medicamentos</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=7">
                <div class="refrigeradosButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Refrigerados</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=8">
                <div class="licorButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Licor</label>
                    </div>
                </div>
            </a>

            <a href="Servlet?menu=Section&action=searchSection&secCode=9">
                <div class="aseoButtom">
                    <div class="whiteSquare">
                        <label class="seccionText">Aseo</label>
                    </div>
                </div>
            </a>

		<form action="Servlet?menu=Section" method="post">	
			<input type="submit" class="buttomSeccion" name="action" value="Crear">

            <input type="submit" class="buttomSeccion" name="action" value="Consultar">

            <input type="submit" class="buttomSeccion" name="action" value="Modificar">
		</form>	
        </div>
</body>
</html>