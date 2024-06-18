<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Pasajeros</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Pasajeros Registrados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre Completo</th>
            <th>Documento de Identidad</th>
            <th>Número de Teléfono</th>
            <th>Correo Electrónico</th>
            <th>Fecha de Viaje</th>
            <th>Fecha de Nacimiento</th>
            <th>Nacionalidad</th>
        </tr>
        <c:forEach items="${pasajeros}" var="pasajero">
            <tr>
                <td><c:out value="${pasajero.id}"/></td>
                <td><c:out value="${pasajero.nombreCompleto}"/></td>
                <td><c:out value="${pasajero.documentoIdentidad}"/></td>
                <td><c:out value="${pasajero.numeroTelefono}"/></td>
                <td><c:out value="${pasajero.correoElectronico}"/></td>
                <td><c:out value="${pasajero.fechaViaje}"/></td>
                <td><c:out value="${pasajero.fechaNacimiento}"/></td>
                <td><c:out value="${pasajero.nacionalidad}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
