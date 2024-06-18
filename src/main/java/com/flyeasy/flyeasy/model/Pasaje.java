package com.flyeasy.flyeasy.model;

public class Pasaje {
    // atributos Pasaje
    private int id;
    private Vuelo vuelo;
    private Pasajero pasajero;
    private String tipoPasaje;
    private String asiento;

    // constructor Pasaje
    public Pasaje(int id, Vuelo vuelo, Pasajero pasajero, String tipoPasaje, String asiento) {
        this.id = id;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.tipoPasaje = tipoPasaje;
        this.asiento = asiento;
    }

    // getters y setters Pasaje
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getTipoPasaje() {
        return tipoPasaje;
    }

    public void setTipoPasaje(String tipoPasaje) {
        this.tipoPasaje = tipoPasaje;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
}
