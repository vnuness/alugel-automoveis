/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.Devolutiva;

import DAO.DevolutivaDAO;
import Models.Devolutiva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mia_a
 */
@WebServlet(name = "DevolutivaServlet", urlPatterns = {"/salvar"})
public class DevolutivaSalvarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(String metodoHttp,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (metodoHttp.equals("POST")) { // Aqui verifico se o que veio na requisição é POST
            if (request.getParameter("id_cliente") != null 
                    || request.getParameter("id_avaliacao") != null
                    || request.getParameter("id_tipo_devolutiva") != null
                    || request.getParameter("id_status_locacao") != null
                    || request.getParameter("observacao") != null
                    ) { // Aqui verifico se o parametro INATIVAR veio na requisição. Caso sim, o usuário está tentando inativar um Cliente.
                response.setContentType("application/json"); //aqui defino que o tipo de retorno deve ser JSON, para conseguirmos capturar a mensagem na view
                
                Devolutiva devolutiva = new Devolutiva();
                devolutiva.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
                devolutiva.setId_avaliacao(Integer.parseInt(request.getParameter("id_avaliacao")));
                devolutiva.setId_tipo_devolutiva(Integer.parseInt(request.getParameter("id_tipo_devolutiva")));
                devolutiva.setId_status_locacao(Integer.parseInt(request.getParameter("id_status_locacao")));
                devolutiva.setObservacao(request.getParameter("observacao"));
                
               
                
                if (DevolutivaDAO.Salvar(devolutiva)) { // Aqui chamo o metodo inativar da DAO, passando o ID por parametro
                    String resposta = "{\"return\" : \"success\"}"; //Aqui defino o que será retornado para a view em caso de sucesso
                    try (PrintWriter out = response.getWriter()) {
                        out.println(resposta);
                    }
                } else {
                    String resposta = "{\"return\" : \"error\"}"; //Aqui defino o que será retornado para a view em caso de erro
                    try (PrintWriter out = response.getWriter()) {
                        out.println(resposta);
                    }
                }
            }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest("Post",request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
