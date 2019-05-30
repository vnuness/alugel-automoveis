/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.login;

import DAO.LoginDAO;
import Models.Funcionario;
import Models.Login;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mia_a
 */
 @WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String email = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        Login login = new Login(email, senha);
        response.setContentType("application/json");
        if (LoginDAO.login(login)) {
            HttpSession sessao = request.getSession();
            int id = LoginDAO.getInfoUsuario(email).get(0).getId();
            String nome = LoginDAO.getInfoUsuario(email).get(0).getNome();
            String emailUser = LoginDAO.getInfoUsuario(email).get(0).getEmail();
            int idFilial = LoginDAO.getInfoUsuario(email).get(0).getIdFilial();
            int idCargo = LoginDAO.getInfoUsuario(email).get(0).getIdCargo();
            
            sessao.setAttribute("idUsuario", id);
            sessao.setAttribute("nome", nome);
            sessao.setAttribute("email", emailUser);
            sessao.setAttribute("idFilial", idFilial);
            sessao.setAttribute("idCargo", idCargo);
            String resposta = "{\"idCargo\" : \"" + idCargo +"\"}";
            try (PrintWriter out = response.getWriter()) {
                out.println(resposta);
            }
        } else {
            String resposta = "{\"return\" : \"error\"}";
            try (PrintWriter out = response.getWriter()) {
                out.println(resposta);
            }
        }

    }

@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest("GET",request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest("POST", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
