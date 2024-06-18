package com.flyeasy.flyeasy.controller;


import com.flyeasy.flyeasy.model.Aerolinea;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import com.flyeasy.flyeasy.model.data.dao.AerolineaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registroAerolineaServlet", value = "/registroAerolinea")
public class RegistroAerolineaServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroAerolinea.jsp");
        respuesta.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String codigoIATA = req.getParameter("codigoIATA");
        String imagenCorporativa = req.getParameter("imagenCorporativa");

        Aerolinea aerolinea = new Aerolinea(0, nombre, codigoIATA, imagenCorporativa);
        try {
            AerolineaDAO.agregarAerolinea(DBGenerator.conectarBD("FlyEasyDB"), aerolinea);
            req.setAttribute("aerolinea", aerolinea);
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        }
    }
}
