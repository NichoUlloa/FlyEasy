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
    <title>Mostrar Pasajes</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Pasajes Registrados</h1>
<div class="centrado">
    <table>
        <tr>
            <th>ID</th>
            <th>ID del Vuelo</th>
            <th>ID del Pasajero</th>
            <th>Tipo de Pasaje</th>
            <th>Asiento</th>
        </tr>
        <c:forEach items="${pasajes}" var="pasaje">
            <tr>
                <td><c:out value="${pasaje.id}"/></td>
                <td><c:out value="${pasaje.vuelo.id}"/></td>
                <td><c:out value="${pasaje.pasajero.id}"/></td>
                <td><c:out value="${pasaje.tipoPasaje}"/></td>
                <td><c:out value="${pasaje.asiento}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
