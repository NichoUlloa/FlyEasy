<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Aerolíneas</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>
    <h1>Listado de Aerolíneas</h1>
</header>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
    </ul>
</nav>
<main>
    <section>
        <h2>Aerolíneas Registradas</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Código IATA</th>
                <th>Imagen Corporativa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="aerolinea" items="${aerolineas}">
                <tr>
                    <td><c:out value="${aerolinea.id}"/></td>
                    <td><c:out value="${aerolinea.nombre}"/></td>
                    <td><c:out value="${aerolinea.codigoIATA}"/></td>
                    <td><img src="${aerolinea.imagenCorporativa}" alt="Imagen Corporativa"/></td>
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
