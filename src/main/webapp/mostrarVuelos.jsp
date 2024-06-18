<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Vuelos</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Vuelos Registrados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>ID</th>
            <th>Número de Vuelo</th>
            <th>Aerolínea</th>
            <th>Origen</th>
            <th>Destino</th>
            <th>Fecha de Salida</th>
            <th>Fecha de Llegada</th>
            <th>Hora de Salida</th>
            <th>Hora de Llegada</th>
            <th>Duración</th>
            <th>Tipo de Aeronave</th>
            <th>Capacidad de Pasajeros</th>
        </tr>
        <c:forEach items="${vuelos}" var="vuelo">
            <tr>
                <td><c:out value="${vuelo.id}"/></td>
                <td><c:out value="${vuelo.numeroVuelo}"/></td>
                <td><c:out value="${vuelo.aerolinea}"/></td>
                <td><c:out value="${vuelo.origen}"/></td>
                <td><c:out value="${vuelo.destino}"/></td>
                <td><c:out value="${vuelo.fechaSalida}"/></td>
                <td><c:out value="${vuelo.fechaLlegada}"/></td>
                <td><c:out value="${vuelo.horaSalida}"/></td>
                <td><c:out value="${vuelo.horaLlegada}"/></td>
                <td><c:out value="${vuelo.duracion}"/></td>
                <td><c:out value="${vuelo.tipoAeronave}"/></td>
                <td><c:out value="${vuelo.capacidadPasajeros}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
