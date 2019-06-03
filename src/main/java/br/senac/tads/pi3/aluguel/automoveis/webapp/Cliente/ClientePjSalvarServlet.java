package br.senac.tads.pi3.aluguel.automoveis.webapp.Cliente;

import DAO.PessoaJuridicaDAO;
import Models.PessoaJuridica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rapha
 */

 @WebServlet(name = "ClientePjSalvarServlet", urlPatterns = {"/cliente/pj/salvar"})
 public class ClientePjSalvarServlet extends HttpServlet {

     private void processarRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
                    String nome = request.getParameter("nome");
                    String cpfCnpj = request.getParameter("cpf_cnpj");
                    String cnh = request.getParameter("cnh");
                    String email = request.getParameter("email");
                    String endereco = request.getParameter("endereco");
                    String cep = request.getParameter("cep");
                    String bairro = request.getParameter("bairro");
                    String complemento = "";
                    String validadeCnh = request.getParameter("validade_cnh");
                    String cidade = request.getParameter("cidade");
                    String estado = request.getParameter("estado");
                    int numero = Integer.parseInt(request.getParameter("numero"));
                    String celular = request.getParameter("celular");
                    int categoria = Integer.parseInt(request.getParameter("categoria_cnh"));
                    int tipo = Integer.parseInt(request.getParameter("tipo"));
                    PessoaJuridica pj = new PessoaJuridica(nome, cpfCnpj, cnh, categoria, email, validadeCnh, endereco, cep, bairro, complemento, cidade, estado, celular, tipo, numero);
                    response.setContentType("application/json");
                    PessoaJuridicaDAO pjd = new PessoaJuridicaDAO();
                    if (pjd.salvar(pj)) {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processarRequisicao("GET", request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processarRequisicao("POST", request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 }