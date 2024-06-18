package com.flyeasy.flyeasy.controller;

import com.flyeasy.flyeasy.model.Vuelo;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import com.flyeasy.flyeasy.model.data.dao.VueloDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroVueloServlet", value = "/registroVuelo")
public class RegistroVueloServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroVuelo.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroVuelo = req.getParameter("numeroVuelo");
        String aerolinea = req.getParameter("aerolinea");
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        String fechaSalida = req.getParameter("fechaSalida");
        String fechaLlegada = req.getParameter("fechaLlegada");
        String horaSalida = req.getParameter("horaSalida");
        String horaLlegada = req.getParameter("horaLlegada");
        String duracion = req.getParameter("duracion");
        String tipoAeronave = req.getParameter("tipoAeronave");
        int capacidadPasajeros = Integer.parseInt(req.getParameter("capacidadPasajeros"));

        Vuelo vuelo = new Vuelo(0, numeroVuelo, aerolinea, origen, destino, fechaSalida, fechaLlegada, horaSalida, horaLlegada, duracion, tipoAeronave, capacidadPasajeros);
        try {
            VueloDAO.agregarVuelo(DBGenerator.conectarBD("FlyEasyDB"), vuelo);
            req.setAttribute("vuelo", vuelo);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        }
    }
}
