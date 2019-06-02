/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.Cliente;

import DAO.ClienteDAO;
import Models.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oem
 */
@WebServlet(name = "ClientePjAtualizar", urlPatterns = {"/cliente/pj/atualizar"})
public class ClientePjAtualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cpf_cnpj");
        String cnh = request.getParameter("cnh");
        int idCategoriaCnh = Integer.parseInt(request.getParameter("categoria_cnh"));
        String email = request.getParameter("email");
        String validadeCnh = request.getParameter("validade_cnh");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String celular = request.getParameter("celular");
        int idCategoriaCliente = Integer.parseInt(request.getParameter("categoria_cliente"));
        int numero = Integer.parseInt(request.getParameter("numero"));

        Cliente c = new Cliente(id, nome, cnpj, cnh, idCategoriaCnh, email, validadeCnh, endereco, cep, bairro, complemento, cidade, estado, celular, idCategoriaCliente, numero);

        response.setContentType("application/json");
        
        if (ClienteDAO.atualizar(c)) {
            String resposta = "{\"return\" : \"success\"}";
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
