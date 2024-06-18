<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<header>
    <title>Registro de Vuelo</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</header>
<body>
<h1 class="encabezado">Registro de Vuelo</h1>
<div class="centrado">
    <form action="registroVuelo" method="post">
        <label for="numeroVuelo">Número de Vuelo:</label>
        <input type="text" id="numeroVuelo" name="numeroVuelo"><br>
        <label for="aerolinea">Aerolínea:</label>
        <input type="text" id="aerolinea" name="aerolinea"><br>
        <label for="origen">Origen:</label>
        <input type="text" id="origen" name="origen"><br>
        <label for="destino">Destino:</label>
        <input type="text" id="destino" name="destino"><br>
        <label for="fechaSalida">Fecha de Salida:</label>
        <input type="text" id="fechaSalida" name="fechaSalida"><br>
        <label for="fechaLlegada">Fecha de Llegada:</label>
        <input type="text" id="fechaLlegada" name="fechaLlegada"><br>
        <label for="horaSalida">Hora de Salida:</label>
        <input type="text" id="horaSalida" name="horaSalida"><br>
        <label for="horaLlegada">Hora de Llegada:</label>
        <input type="text" id="horaLlegada" name="horaLlegada"><br>
        <label for="duracion">Duración:</label>
        <input type="text" id="duracion" name="duracion"><br>
        <label for="tipoAeronave">Tipo de Aeronave:</label>
        <input type="text" id="tipoAeronave" name="tipoAeronave"><br>
        <label for="capacidadPasajeros">Capacidad de Pasajeros:</label>
        <input type="text" id="capacidadPasajeros" name="capacidadPasajeros"><br>
        <input class="boton" type="submit" value="Registrar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
