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
import java.util.List;

@WebServlet(name = "mostrarAerolineasServlet", value = "/mostrarAerolineas")
public class MostrarAerolineasServlet extends HttpServlet {
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
            List<Aerolinea> aerolineas = AerolineaDAO.obtenerAerolineas(DBGenerator.conectarBD("FlyEasyDB"));
            req.setAttribute("aerolineas", aerolineas);
            RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarAerolineas.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
