package com.flyeasy.flyeasy.model.data.dao;

import com.flyeasy.flyeasy.model.Pasajero;
import com.flyeasy.flyeasy.model.data.DBConnector;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class PasajeroDAO {

    public static void agregarPasajero(DSLContext query, Pasajero pasajero) {
        Table<?> tablaPasajero = table(name("Pasajero"));
        Field<String> nombreCompleto = field(name("nombreCompleto"), VARCHAR(255));
        Field<String> documentoIdentidad = field(name("documentoIdentidad"), VARCHAR(255));
        Field<String> numeroTelefono = field(name("numeroTelefono"), VARCHAR(255));
        Field<String> correoElectronico = field(name("correoElectronico"), VARCHAR(255));
        Field<String> fechaViaje = field(name("fechaViaje"), VARCHAR(255));
        Field<String> fechaNacimiento = field(name("fechaNacimiento"), VARCHAR(255));
        Field<String> nacionalidad = field(name("nacionalidad"), VARCHAR(255));

        query.insertInto(tablaPasajero, nombreCompleto, documentoIdentidad, numeroTelefono, correoElectronico, fechaViaje, fechaNacimiento, nacionalidad)
                .values(pasajero.getNombreCompleto(), pasajero.getDocumentoIdentidad(), pasajero.getNumeroTelefono(), pasajero.getCorreoElectronico(), pasajero.getFechaViaje(), pasajero.getFechaNacimiento(), pasajero.getNacionalidad())
                .execute();
    }

    public static List<Pasajero> obtenerPasajeros(DSLContext query) {
        List<Pasajero> pasajeros = new ArrayList<>();
        Result<?> resultados = query.select().from(DSL.table("Pasajero")).fetch();
        for (Record resultado : resultados) {
            pasajeros.add(new Pasajero(
                    resultado.get("id", Integer.class),
                    resultado.get("nombreCompleto", String.class),
                    resultado.get("documentoIdentidad", String.class),
                    resultado.get("numeroTelefono", String.class),
                    resultado.get("correoElectronico", String.class),
                    resultado.get("fechaViaje", String.class),
                    resultado.get("fechaNacimiento", String.class),
                    resultado.get("nacionalidad", String.class)
            ));
        }
        return pasajeros;
    }

    public static Pasajero obtenerPasajeroPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Pasajero")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Pasajero(
                    record.get("id", Integer.class),
                    record.get("nombreCompleto", String.class),
                    record.get("documentoIdentidad", String.class),
                    record.get("numeroTelefono", String.class),
                    record.get("correoElectronico", String.class),
                    record.get("fechaViaje", String.class),
                    record.get("fechaNacimiento", String.class),
                    record.get("nacionalidad", String.class)
            );
        }
        return null;
    }
}
