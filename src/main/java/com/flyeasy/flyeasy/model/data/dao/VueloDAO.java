package com.flyeasy.flyeasy.model.data.dao;

import com.flyeasy.flyeasy.model.Vuelo;
import com.flyeasy.flyeasy.model.data.DBConnector;
import org.jooq.DSLContext;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;


public class VueloDAO {

    public static void agregarVuelo(DSLContext query, Vuelo vuelo) {
        Table<?> tablaVuelo = table(name("Vuelo"));
        Field<String> numeroVuelo = field(name("numeroVuelo"), VARCHAR(255));
        Field<String> aerolinea = field(name("aerolinea"), VARCHAR(255));
        Field<String> origen = field(name("origen"), VARCHAR(255));
        Field<String> destino = field(name("destino"), VARCHAR(255));
        Field<String> fechaSalida = field(name("fechaSalida"), VARCHAR(255));
        Field<String> fechaLlegada = field(name("fechaLlegada"), VARCHAR(255));
        Field<String> horaSalida = field(name("horaSalida"), VARCHAR(255));
        Field<String> horaLlegada = field(name("horaLlegada"), VARCHAR(255));
        Field<String> duracion = field(name("duracion"), VARCHAR(255));
        Field<String> tipoAeronave = field(name("tipoAeronave"), VARCHAR(255));
        Field<Integer> capacidadPasajeros = field(name("capacidadPasajeros"), INTEGER);

        query.insertInto(tablaVuelo, numeroVuelo, aerolinea, origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada, duracion, tipoAeronave, capacidadPasajeros)
                .values(vuelo.getNumeroVuelo(), vuelo.getAerolinea(), vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFechaSalida(), vuelo.getFechaLlegada(), vuelo.getHoraSalida(), vuelo.getHoraLlegada(), vuelo.getDuracion(), vuelo.getTipoAeronave(), vuelo.getCapacidadPasajeros())
                .execute();
    }

    public static List<Vuelo> obtenerVuelos(DSLContext query) {
        List<Vuelo> vuelos = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Vuelo")).fetch();
        for (Record resultado : resultados) {
            vuelos.add(new Vuelo(
                    resultado.get("id", Integer.class),
                    resultado.get("numeroVuelo", String.class),
                    resultado.get("aerolinea", String.class),
                    resultado.get("origen", String.class),
                    resultado.get("destino", String.class),
                    resultado.get("fechaSalida", String.class),
                    resultado.get("fechaLlegada", String.class),
                    resultado.get("horaSalida", String.class),
                    resultado.get("horaLlegada", String.class),
                    resultado.get("duracion", String.class),
                    resultado.get("tipoAeronave", String.class),
                    resultado.get("capacidadPasajeros", Integer.class)
            ));
        }
        return vuelos;
    }

    public static Vuelo obtenerVueloPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Vuelo")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Vuelo(
                    record.get("id", Integer.class),
                    record.get("numeroVuelo", String.class),
                    record.get("aerolinea", String.class),
                    record.get("origen", String.class),
                    record.get("destino", String.class),
                    record.get("fechaSalida", String.class),
                    record.get("fechaLlegada", String.class),
                    record.get("horaSalida", String.class),
                    record.get("horaLlegada", String.class),
                    record.get("duracion", String.class),
                    record.get("tipoAeronave", String.class),
                    record.get("capacidadPasajeros", Integer.class)
            );
        }
        return null;
    }
}

