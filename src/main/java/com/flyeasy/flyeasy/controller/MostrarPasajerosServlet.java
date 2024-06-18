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
import java.util.List;

@WebServlet(name = "mostrarPasajerosServlet", value = "/mostrarPasajeros")
public class MostrarPasajerosServlet extends HttpServlet {
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
        try {
            List<Pasajero> pasajeros = PasajeroDAO.obtenerPasajeros(DBGenerator.conectarBD("FlyEasyDB"));
            req.setAttribute("pasajeros", pasajeros);
            RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarPasajeros.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
