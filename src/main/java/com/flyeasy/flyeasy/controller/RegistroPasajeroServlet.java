package com.flyeasy.flyeasy.controller;


import com.flyeasy.flyeasy.model.Pasajero;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import com.flyeasy.flyeasy.model.data.dao.PasajeroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroPasajeroServlet", value = "/registroPasajero")
public class RegistroPasajeroServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroPasajero.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreCompleto = req.getParameter("nombreCompleto");
        String documentoIdentidad = req.getParameter("documentoIdentidad");
        String numeroTelefono = req.getParameter("numeroTelefono");
        String correoElectronico = req.getParameter("correoElectronico");
        String fechaViaje = req.getParameter("fechaViaje");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String nacionalidad = req.getParameter("nacionalidad");

        Pasajero pasajero = new Pasajero(0, nombreCompleto, documentoIdentidad, numeroTelefono, correoElectronico, fechaViaje, fechaNacimiento, nacionalidad);
        try {
            PasajeroDAO.agregarPasajero(DBGenerator.conectarBD("FlyEasyDB"), pasajero);
            req.setAttribute("pasajero", pasajero);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        }
    }
}
