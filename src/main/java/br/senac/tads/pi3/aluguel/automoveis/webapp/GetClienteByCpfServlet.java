/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp;

import DAO.ClienteDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedrocruz
 */
@WebServlet(name = "GetClienteByCpfServlet", urlPatterns = {"/cliente/search"})
public class GetClienteByCpfServlet extends HttpServlet {

    private void processarRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ParseException {
        response.setContentType("application/json");
        String cpf = request.getParameter("cpf");
        String json = new Gson().toJson(ClienteDAO.getClienteCpf(cpf)); // AQUI uso uma API do Google que converte um ArrayList em JSON. Faço isso por que é melhor para tratar os dados no javascript/jquery
        try (PrintWriter out = response.getWriter()) {
            out.println(json);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processarRequisicao("GET", request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
