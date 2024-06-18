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
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "MostrarAerolineasServlet", value = "/mostrarAerolineas")
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Aerolinea> aerolineas = AerolineaDAO.obtenerAerolineas();
            request.setAttribute("aerolineas", aerolineas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mostrarAerolineas.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

