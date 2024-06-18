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
    <title>Registro de Pasaje</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Registro de Pasaje</h1>
<div class="centrado">
    <form action="registroPasaje" method="post">
        <label for="idVuelo">ID del Vuelo:</label>
        <input type="text" id="idVuelo" name="idVuelo"><br>
        <label for="idPasajero">ID del Pasajero:</label>
        <input type="text" id="idPasajero" name="idPasajero"><br>
        <label for="tipoPasaje">Tipo de Pasaje:</label>
        <input type="text" id="tipoPasaje" name="tipoPasaje"><br>
        <label for="asiento">Asiento:</label>
        <input type="text" id="asiento" name="asiento"><br>
        <input class="boton" type="submit" value="Registrar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
