package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PontoBean;
import database.PontoDAO;

@WebServlet("/pontos")
public class PontoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PontoDAO pontoDao = new PontoDAO();
        List<PontoBean> listaPontos = pontoDao.selectAllPontos();
        request.setAttribute("pontos", listaPontos);
        RequestDispatcher view = request.getRequestDispatcher("/pages/pontos.jsp");
        view.forward(request, response);
    }
}