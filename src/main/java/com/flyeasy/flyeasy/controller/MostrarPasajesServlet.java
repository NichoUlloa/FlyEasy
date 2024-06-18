package com.flyeasy.flyeasy.controller;

import com.flyeasy.flyeasy.model.Pasaje;
import com.flyeasy.flyeasy.model.data.DBGenerator;
import com.flyeasy.flyeasy.model.data.dao.PasajeDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mostrarPasajesServlet", value = "/mostrarPasajes")
public class MostrarPasajesServlet extends HttpServlet {
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
            List<Pasaje> pasajes = PasajeDAO.obtenerPasajes(DBGenerator.conectarBD("FlyEasyDB"));
            req.setAttribute("pasajes", pasajes);
            RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarPasajes.jsp");
            respuesta.forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
