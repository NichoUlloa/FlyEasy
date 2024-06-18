# Fly Easy - Sistema de Gestión de Vuelos

## Descripción
**Fly Easy** es una empresa de viajes que busca desarrollar un sistema web para la gestión y venta de pasajes aéreos. El sistema permitirá a los usuarios:
- Buscar vuelos por diferentes criterios (origen, destino, fecha, aerolínea, etc.).
- Ver información detallada de cada vuelo (horarios, escalas, precios, etc.).
- Reservar y comprar pasajes de los vuelos seleccionados.
- Gestionar sus reservas (modificar, cancelar, ver detalles).
- Acceder a su historial de viajes.

## Requerimientos Funcionales
Para gestionar el principal proceso de negocio de la empresa, se necesita diseñar y desarrollar un programa que cumpla con los siguientes requerimientos:

### Vuelo
Se desea gestionar información como el número de vuelo, la aerolínea, el origen, el destino, la fecha de salida, la fecha de llegada, el horario de salida, el horario de llegada, la duración del vuelo, el tipo de aeronave y la capacidad de pasajeros.

### Aerolínea
Se manejará información relevante de las aerolíneas como el nombre, el código IATA y la imagen corporativa.

### Pasajero
Se llevará un control de los usuarios que reservan pasajes, su información de contacto (nombre completo, documento de identidad, número de teléfono, correo electrónico) y sus datos de viaje (fecha de nacimiento, nacionalidad).

### Pasaje
Se gestionarán los distintos tipos de pasajes disponibles para cada vuelo (económico, ejecutivo, primera clase), precios y disponibilidad. Un vuelo ofrece varios tipos de pasajes. Cada pasaje estará asociado a un vuelo y un pasajero. Por último, se debe permitir la selección de asientos durante el proceso de compra.

