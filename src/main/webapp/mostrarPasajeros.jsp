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
    <title>Mostrar Pasajeros</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>
    <h1>Listado de Pasajeros</h1>
</header>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
    </ul>
</nav>
<main>
    <section>
        <h2>Pasajeros Registrados</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre Completo</th>
                <th>Documento Identidad</th>
                <th>Teléfono</th>
                <th>Correo Electrónico</th>
                <th>Fecha de Nacimiento</th>
                <th>Nacionalidad</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="pasajero" items="${pasajeros}">
                <tr>
                    <td><c:out value="${pasajero.idPasajero}"/></td>
                    <td><c:out value="${pasajero.nombreCompleto}"/></td>
                    <td><c:out value="${pasajero.documentoIdentidad}"/></td>
                    <td><c:out value="${pasajero.telefono}"/></td>
                    <td><c:out value="${pasajero.correoElectronico}"/></td>
                    <td><c:out value="${pasajero.fechaNacimiento}"/></td>
                    <td><c:out value="${pasajero.nacionalidad}"/></td>
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
