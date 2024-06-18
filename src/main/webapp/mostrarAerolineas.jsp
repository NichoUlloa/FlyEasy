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
    <title>Mostrar Aerolíneas</title>
    <link rel="stylesheet" type="text/css" href="css/estilos.css">
</head>
<body>
<h1 class="encabezado">Aerolíneas Registradas</h1>
<div class="centrado">
    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Código IATA</th>
            <th>Imagen Corporativa</th>
        </tr>
        <c:forEach items="${aerolineas}" var="aerolinea">
            <tr>
                <td><c:out value="${aerolinea.id}"/></td>
                <td><c:out value="${aerolinea.nombre}"/></td>
                <td><c:out value="${aerolinea.codigoIATA}"/></td>
                <td><c:out value="${aerolinea.imagenCorporativa}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</body>
</html>
