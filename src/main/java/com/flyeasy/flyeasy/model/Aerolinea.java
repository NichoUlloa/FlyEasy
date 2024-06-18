package com.flyeasy.flyeasy.model;

public class Aerolinea {
    // atributos Aerolinea
    private int id;
    private String nombre;
    private String codigoIATA;
    private String imagenCorporativa;

    // constructor Aerolinea
    public Aerolinea(int id, String nombre, String codigoIATA, String imagenCorporativa) {
        this.id = id;
        this.nombre = nombre;
        this.codigoIATA = codigoIATA;
        this.imagenCorporativa = imagenCorporativa;
    }

    // getters y setters Aerolinea

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getImagenCorporativa() {
        return imagenCorporativa;
    }

    public void setImagenCorporativa(String imagenCorporativa) {
        this.imagenCorporativa = imagenCorporativa;
    }
}
