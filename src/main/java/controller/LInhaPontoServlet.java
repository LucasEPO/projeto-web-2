package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.LinhaPontoBean;
import model.PontoBean;
import database.LinhaPontoDAO;
import database.PontoDAO;

@WebServlet("/linha-ponto")
public class LInhaPontoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // LinhaPontoDAO linhaPontoDAO = new LinhaPontoDAO();
        // Long ponto_id = Long.valueOf(request.getParameter("pontoId"));
        // List<LinhaPontoBean> listaLinhaPonto =
        // linhaPontoDAO.selectLinhaPonto(ponto_id);
        // Gson gson = new Gson();
        // String jsonListaLinhaPonto = gson.toJson(listaLinhaPonto);
        // response.setContentType("application/json");
        // response.setCharacterEncoding("UTF-8");

        // PrintWriter out = response.getWriter();
        // out.print(jsonListaLinhaPonto);
        // out.flush();

        LinhaPontoDAO linhaPontoDAO = new LinhaPontoDAO();
        Long ponto_id = Long.valueOf(request.getParameter("pontoId"));
        List<LinhaPontoBean> listaLinhaPonto = linhaPontoDAO.selectLinhaPonto(ponto_id);
        request.setAttribute("linha-ponto", listaLinhaPonto);
        RequestDispatcher view = request.getRequestDispatcher("/pages/linha-ponto.jsp");
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getParameter("linhaId"));
        System.out.println(request.getParameter("pontoId"));
        System.out.println(request.getParameter("horario"));

        Long linha_id = Long.valueOf(request.getParameter("linhaId"));
        Long ponto_id = Long.valueOf(request.getParameter("pontoId"));
        String horario = request.getParameter("horario");

        System.out.println(linha_id);
        System.out.println(ponto_id);
        System.out.println(horario);

        LinhaPontoDAO linhaPontoDAO = new LinhaPontoDAO();
        linhaPontoDAO.updateHorario(horario, linha_id, ponto_id);
        response.setStatus(200);
    }
}