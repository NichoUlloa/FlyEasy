<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Aerolínea</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Registro de Aerolínea</h1>
<div class="centrado">
    <form action="registroAerolinea" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre"><br>
        <label for="codigoIATA">Código IATA:</label>
        <input type="text" id="codigoIATA" name="codigoIATA"><br>
        <label for="imagenCorporativa">Imagen Corporativa:</label>
        <input type="text" id="imagenCorporativa" name="imagenCorporativa"><br>
        <input class="boton" type="submit" value="Registrar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
