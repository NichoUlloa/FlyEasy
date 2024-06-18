<%--
  Created by IntelliJ IDEA.
  User: Nicho
  Date: 18-06-2024
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Vuelos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
<header>
    <h1>Listado de Vuelos</h1>
</header>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a></li>
    </ul>
</nav>
<main>
    <section>
        <h2>Vuelos Registrados</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Número de Vuelo</th>
                <th>Origen</th>
                <th>Destino</th>
                <th>Fecha de Salida</th>
                <th>Fecha de Llegada</th>
                <th>Horario de Salida</th>
                <th>Horario de Llegada</th>
                <th>Duración del Vuelo</th>
                <th>Tipo de Aeronave</th>
                <th>Capacidad de Pasajeros</th>
                <th>ID Aerolínea</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vuelo" items="${vuelos}">
                <tr>
                    <td>${vuelo.idVuelo}</td>
                    <td>${vuelo.numeroVuelo}</td>
                    <td>${vuelo.origen}</td>
                    <td>${vuelo.destino}</td>
                    <td>${vuelo.fechaSalida}</td>
                    <td>${vuelo.fechaLlegada}</td>
                    <td>${vuelo.horarioSalida}</td>
                    <td>${vuelo.horarioLlegada}</td>
                    <td>${vuelo.duracionVuelo}</td>
                    <td>${vuelo.tipoAeronave}</td>
                    <td>${vuelo.capacidadPasajeros}</td>
                    <td>${vuelo.idAerolinea}</td>
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
