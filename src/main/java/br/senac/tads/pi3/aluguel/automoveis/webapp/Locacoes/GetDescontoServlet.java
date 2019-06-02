/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.Locacoes;

import DAO.LocacaoDAO;
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
@WebServlet(name = "GetDescontoServlet", urlPatterns = {"/get-desconto"})
public class GetDescontoServlet extends HttpServlet {

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
        int idCategoriaCliente = Integer.parseInt(request.getParameter("id_categoria"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int qtdDias = Integer.parseInt(request.getParameter("qtd_dias"));
        double valorDesconto;
        PessoaFisica pf = new PessoaFisica();
        MotoristaAplicativo ma = new MotoristaAplicativo();
        if (idCategoriaCliente == 1) {
            valorDesconto = pf.aplicaDesconto(valor, qtdDias);
        } else if(idCategoriaCliente == 3) {
            valorDesconto = ma.aplicaDesconto(valor, qtdDias);
        } else {
            valorDesconto = valor;
        }
        response.setContentType("application/json");
        String resposta = "{\"valor\" : \"" + valorDesconto + "\"}";
        try (PrintWriter out = response.getWriter()) {
            out.println(resposta);
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
