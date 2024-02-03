package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.LinhaBean;
import database.LinhaDAO;

@WebServlet("/linhas")
public class LinhaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LinhaDAO linhasDAO = new LinhaDAO();
        List<LinhaBean> listaLinhas = LinhaDAO.selectAllLinhas();
        Gson gson = new Gson();
        String jsonListaLinhas = gson.toJson(listaLinhas);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(jsonListaLinhas);
        out.flush();

    }
}