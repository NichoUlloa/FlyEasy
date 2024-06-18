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
<header>
    <title>Registro de Pasajero</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</header>
<body>
<h1 class="encabezado">Registro de Pasajero</h1>
<div class="centrado">
    <form action="registroPasajero" method="post">
        <label for="nombreCompleto">Nombre Completo:</label>
        <input type="text" id="nombreCompleto" name="nombreCompleto"><br>
        <label for="documentoIdentidad">Documento de Identidad:</label>
        <input type="text" id="documentoIdentidad" name="documentoIdentidad"><br>
        <label for="numeroTelefono">Número de Teléfono:</label>
        <input type="text" id="numeroTelefono" name="numeroTelefono"><br>
        <label for="correoElectronico">Correo Electrónico:</label>
        <input type="text" id="correoElectronico" name="correoElectronico"><br>
        <label for="fechaViaje">Fecha de Viaje:</label>
        <input type="text" id="fechaViaje" name="fechaViaje"><br>
        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
        <input type="text" id="fechaNacimiento" name="fechaNacimiento"><br>
        <label for="nacionalidad">Nacionalidad:</label>
        <input type="text" id="nacionalidad" name="nacionalidad"><br>
        <input class="boton" type="submit" value="Registrar">
    </form>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
