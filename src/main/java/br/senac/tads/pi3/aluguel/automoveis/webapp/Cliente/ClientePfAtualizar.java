/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.Cliente;

import DAO.PessoaFisicaDAO;
import Models.MotoristaAplicativo;
import Models.PessoaFisica;
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
@WebServlet(name = "ClientePfAtualizar", urlPatterns = {"/cliente/pf/atualizar"})
public class ClientePfAtualizar extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf_cnpj");
        int idSexo = Integer.parseInt(request.getParameter("sexo"));
        String cnh =  request.getParameter("cnh");
        int idCategoriaCnh = Integer.parseInt(request.getParameter("categoria_cnh"));
        String rg = request.getParameter("rg");
        String email = request.getParameter("email");
        String nacionalidade = request.getParameter("nacionalidade");
        String nascimento = request.getParameter("nascimento");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String celular = request.getParameter("celular");
        int idStatus = 1;
        int idCategoriaCliente = Integer.parseInt(request.getParameter("categoria_cliente"));
        String validadeCnh = request.getParameter("validade_cnh");
        PessoaFisica pf = null;
        if(idCategoriaCliente == 1) {
            pf = new PessoaFisica(id, nome, cpf, idSexo, cnh, idCategoriaCnh, rg, email, nacionalidade, nascimento, endereco, cep, bairro, complemento, cidade, estado, celular, idStatus, idCategoriaCliente, validadeCnh, numero);
        } else {
            pf = new MotoristaAplicativo(id, nome, cpf, idSexo, cnh, idCategoriaCnh, cep, email, nacionalidade, nascimento, endereco, cep, bairro, complemento, cidade, estado, celular, idStatus, idCategoriaCliente, validadeCnh, numero);
        }
        
        PessoaFisicaDAO pfd = new PessoaFisicaDAO();
        if (pfd.atualizar(pf)) { 
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
