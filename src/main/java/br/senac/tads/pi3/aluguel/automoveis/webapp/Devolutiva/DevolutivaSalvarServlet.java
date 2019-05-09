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
@WebServlet(name = "DevolutivaServlet", urlPatterns = {"/devolutiva/salvar"})
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
    protected void processRequest(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); //aqui defino que o tipo de retorno deve ser JSON, para conseguirmos capturar a mensagem na view

        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idAvaliacao = Integer.parseInt(request.getParameter("id_avaliacao"));
        int idTipoDevolutiva = Integer.parseInt(request.getParameter("id_tipo_devolutiva"));
        int idLocacao = Integer.parseInt(request.getParameter("id_locacao"));
        String observacao = request.getParameter("observacao");

        Devolutiva devolutiva = new Devolutiva(idCliente, idAvaliacao, idTipoDevolutiva, idLocacao, observacao);

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
        processRequest("Post", request, response);
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
