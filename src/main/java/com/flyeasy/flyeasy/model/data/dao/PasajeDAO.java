package com.flyeasy.flyeasy.model.data.dao;

import com.flyeasy.flyeasy.model.Pasaje;
import com.flyeasy.flyeasy.model.Vuelo;
import com.flyeasy.flyeasy.model.Pasajero;
import com.flyeasy.flyeasy.model.data.DBConnector;


import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class PasajeDAO {

    public static void agregarPasaje(DSLContext query, Pasaje pasaje) {
        Table<?> tablaPasaje = table(name("Pasaje"));
        Field<Integer> idVuelo = field(name("idVuelo"), INTEGER);
        Field<Integer> idPasajero = field(name("idPasajero"), INTEGER);
        Field<String> tipoPasaje = field(name("tipoPasaje"), VARCHAR(255));
        Field<String> asiento = field(name("asiento"), VARCHAR(10));

        query.insertInto(tablaPasaje, idVuelo, idPasajero, tipoPasaje, asiento)
                .values(pasaje.getVuelo().getId(), pasaje.getPasajero().getId(), pasaje.getTipoPasaje(), pasaje.getAsiento())
                .execute();
    }

    public static List<Pasaje> obtenerPasajes(DSLContext query) {
        List<Pasaje> pasajes = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Pasaje")).fetch();
        for (Record resultado : resultados) {
            Vuelo vuelo = VueloDAO.obtenerVueloPorId(query, resultado.get("idVuelo", Integer.class));
            Pasajero pasajero = PasajeroDAO.obtenerPasajeroPorId(query, resultado.get("idPasajero", Integer.class));
            pasajes.add(new Pasaje(
                    resultado.get("id", Integer.class),
                    vuelo,
                    pasajero,
                    resultado.get("tipoPasaje", String.class),
                    resultado.get("asiento", String.class)
            ));
        }
        return pasajes;
    }

    public static Pasaje obtenerPasajePorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Pasaje")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            Vuelo vuelo = VueloDAO.obtenerVueloPorId(query, record.get("idVuelo", Integer.class));
            Pasajero pasajero = PasajeroDAO.obtenerPasajeroPorId(query, record.get("idPasajero", Integer.class));
            return new Pasaje(
                    record.get("id", Integer.class),
                    vuelo,
                    pasajero,
                    record.get("tipoPasaje", String.class),
                    record.get("asiento", String.class)
            );
        }
        return null;
    }
}
