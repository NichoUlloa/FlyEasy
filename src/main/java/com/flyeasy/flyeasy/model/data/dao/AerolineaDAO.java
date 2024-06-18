package com.flyeasy.flyeasy.model.data.dao;

import com.flyeasy.flyeasy.model.Aerolinea;
import com.flyeasy.flyeasy.model.data.DBConnector;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class AerolineaDAO {

    public static void agregarAerolinea(DSLContext query, Aerolinea aerolinea) {
        Table<?> tablaAerolinea = table(name("Aerolinea"));
        Field<String> nombre = field(name("nombre"), VARCHAR(255));
        Field<String> codigoIATA = field(name("codigoIATA"), VARCHAR(255));
        Field<String> imagenCorporativa = field(name("imagenCorporativa"), VARCHAR(255));

        query.insertInto(tablaAerolinea, nombre, codigoIATA, imagenCorporativa)
                .values(aerolinea.getNombre(), aerolinea.getCodigoIATA(), aerolinea.getImagenCorporativa())
                .execute();
    }

    public static List<Aerolinea> obtenerAerolineas() throws SQLException, ClassNotFoundException {
        List<Aerolinea> aerolineas = new ArrayList<>();
        DSLContext query = DBGenerator.conectarBD("FlyEasyDB");
        Result<?> resultados = query.select().from("Aerolinea").fetch();
        for (Record resultado : resultados) {
            aerolineas.add(new Aerolinea(
                    resultado.get("id", Integer.class),
                    resultado.get("nombre", String.class),
                    resultado.get("codigoIATA", String.class),
                    resultado.get("imagenCorporativa", String.class)
            ));
        }
        return aerolineas;
    }

    public static Aerolinea obtenerAerolineaPorId(DSLContext query, int id) {
        Result<?> resultado = query.select().from(DSL.table("Aerolinea")).where(DSL.field("id").eq(id)).fetch();
        if (!resultado.isEmpty()) {
            Record record = resultado.get(0);
            return new Aerolinea(
                    record.get("id", Integer.class),
                    record.get("nombre", String.class),
                    record.get("codigoIATA", String.class),
                    record.get("imagenCorporativa", String.class)
            );
        }
        return null;
    }
}
