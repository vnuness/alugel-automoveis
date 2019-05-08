/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp.Locacoes;

import br.senac.tads.pi3.aluguel.automoveis.webapp.Cliente.ClientePfSalvarServlet;
import DAO.LocacaoDAO;
import Models.Locacao;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.Date.parse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "LocacaoSalvar", urlPatterns = {"/locacao/salvar"})
public class LocacaoSalvarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        /**
         Inicio da coletagem de parametros
         **/
        response.setContentType("text/html;charset=UTF-8");
        int idCliente = Integer.parseInt(request.getParameter("id_cliente"));
        int idVeiculo = Integer.parseInt(request.getParameter("id_veiculo"));
        Double valor = Double.parseDouble(request.getParameter("valor"));
        String obs = request.getParameter("obs");
        /*FIM DA COLETAGEM DE PARAMETROS*/
        /*INSTANCIO O OBJETO PASSANDO AS VARIAVEIS POR PARAMETRO*/
        Locacao l = new Locacao(idCliente, idVeiculo, valor, obs);
        response.setContentType("application/json");
        if (LocacaoDAO.Salvar(l)) {
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClientePfSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClientePfSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
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

