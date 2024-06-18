<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Pasajes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>
    <h1>Listado de Pasajes</h1>
</header>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
    </ul>
</nav>
<main>
    <section>
        <h2>Pasajes Registrados</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tipo</th>
                <th>Precio</th>
                <th>ID Vuelo</th>
                <th>ID Pasajero</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pasaje" items="${pasajes}">
                <tr>
                    <td><c:out value="${pasaje.getIdPasaje()}"></c:out></td>
                    <td><c:out value="${pasaje.getTipo()}"></c:out></td>
                    <td><c:out value="${pasaje.getPrecio()}"></c:out></td>
                    <td><c:out value="${pasaje.getIdVuelo()}"></c:out></td>
                    <td><c:out value="${pasaje.getIdPasajero()}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<footer>
    <p>&copy; 2024 Fly Easy. Todos los derechos reservados.</p>
</footer>
</body>
</html>

