package com.flyeasy.flyeasy.controller;


import com.flyeasy.flyeasy.model.Pasaje;
import com.flyeasy.flyeasy.model.Vuelo;
import com.flyeasy.flyeasy.model.Pasajero;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import com.flyeasy.flyeasy.model.data.dao.PasajeDAO;
import com.flyeasy.flyeasy.model.data.dao.VueloDAO;
import com.flyeasy.flyeasy.model.data.dao.PasajeroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroPasajeServlet", value = "/registroPasaje")
public class RegistroPasajeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("FlyEasyDB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroPasaje.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idVuelo = Integer.parseInt(req.getParameter("idVuelo"));
        int idPasajero = Integer.parseInt(req.getParameter("idPasajero"));
        String tipoPasaje = req.getParameter("tipoPasaje");
        String asiento = req.getParameter("asiento");

        try {
            Vuelo vuelo = VueloDAO.obtenerVueloPorId(DBGenerator.conectarBD("FlyEasyDB"), idVuelo);
            Pasajero pasajero = PasajeroDAO.obtenerPasajeroPorId(DBGenerator.conectarBD("FlyEasyDB"), idPasajero);
            Pasaje pasaje = new Pasaje(0, vuelo, pasajero, tipoPasaje, asiento);
            PasajeDAO.agregarPasaje(DBGenerator.conectarBD("FlyEasyDB"), pasaje);
            req.setAttribute("pasaje", pasaje);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        }
    }
}
