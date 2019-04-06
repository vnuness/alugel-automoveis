/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.aluguel.automoveis.webapp;

import DAO.VeiculoDAO;
import DAO.ClienteDAO;
import Models.Cliente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author rapha
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteServlet extends HttpServlet {


   private void processarRequisicao(String metodoHttp, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        // RECUPERA INFORMACOES DA REQUISICAO
        if (metodoHttp.equals("POST")) { // Aqui verifico se o que veio na requisição é POST
            if (request.getParameter("inativar") != null) { // Aqui verifico se o parametro EXCLUIR veio na requisição. Caso sim, o usuário está tentando excluir o veiculo.
                response.setContentType("application/json"); //aqui defino que o tipo de retorno deve ser JSON, para conseguirmos capturar a mensagem na view
                int id = Integer.parseInt(request.getParameter("id")); //Aqui defino o ID com o que veio na requisição
                if (ClienteDAO.Inativar(id)) { // Aqui chamo o metodo excluir da DAO, passando o ID por parametro
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
            String nome = request.getParameter("nome");
            String cpfCnpj = request.getParameter("cpf/cnpj");
            int id_sexo = Integer.parseInt(request.getParameter("Sexo"));
            String cnh = request.getParameter("CNH");
            int idCategoriaCnh = Integer.parseInt(request.getParameter("Categoria cnh"));
            String rg = request.getParameter("Rg");
            String email = request.getParameter("E-mail");
            String nacionalidade = request.getParameter("Nacionalidade");
            String dataNascimentoString = request.getParameter("Data de Nascimento");//?????
            String endereco = request.getParameter("Endereço");
            String cep = request.getParameter("CEP");
            String bairro = request.getParameter("Bairro");
            String complemento = request.getParameter("Complemento");
            String cidade = request.getParameter("Cidade");
            String estado = request.getParameter("Estado");
            String celular = request.getParameter("Celular");
            String status = request.getParameter("Status");
            String categoria = request.getParameter("Categoria");
            response.setContentType("application/json");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date dataNascimento = formatter.parse(dataNascimentoString);
            //Nas linhas acima defini as variaveis com os parametros que vieram na requisicao
            if (request.getParameter("id") == null) { // aqui pergunto se veio ID na requisição. Caso não tenha vindo (igual a null) o usuário está tentando cadastrar um veiculo
                Cliente c = new Cliente(nome, cpfCnpj, id_sexo, cnh, idCategoriaCnh, rg, email, nacionalidade, dataNascimento, endereco,
                cep, bairro, complemento, cidade, estado, celular, status, categoria); // Então instancio um objeto da model para cadastrar (sem id)
                if (ClienteDAO.Salvar(c)) {
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
            } else { // Caso caia no ELSE, significa que o usuario está tentando EDITAR. Ou sejam veio ID na requisição
                int id = Integer.parseInt(request.getParameter("Id"));
                Cliente c = new Cliente(id, nome, cpfCnpj, id_sexo, cnh, idCategoriaCnh, rg, email, nacionalidade, dataNascimento, endereco,
                        cep, bairro, complemento, cidade, estado, celular, status, categoria);
                if (ClienteDAO.Atualizar(c)) {
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

        } else { // ESSE ELSE diz que o tipo de requisição foi GET. A requisição GET foi utilizada maioritariamente para buscar registros no banco de dados
            response.setContentType("application/json");
            if (request.getParameter("getStatus_Usuario_Cliente") != null) { //se Veio status na requisição, significa que estou pedindo os registros da tabela status no banco de DAdos, ou seja, estou querendo preencher meus combobox na view. O mesmo serve para os IFs abaixo*
                String json = new Gson().toJson(ClienteDAO.getStatusClienteUsuarios()); // AQUI uso uma API do Google que converte um ArrayList em JSON. Faço isso por que é melhor para tratar os dados no javascript/jquery
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
            } else if(request.getParameter("getSexo") != null) {
                String json = new Gson().toJson(ClienteDAO.getSexo());
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
            } else if(request.getParameter("getCategoria_CNH") != null) {
                String json = new Gson().toJson(ClienteDAO.getCategoriaCNH());
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
            } else if(request.getParameter("getCategoria_Cliente") != null) {
                String json = new Gson().toJson(ClienteDAO.getCategoriaCliente());
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
            } else{
                int id = Integer.parseInt(request.getParameter("id")); // nesse else, estou buscando os registros para preencher a tabela
                String json = new Gson().toJson(ClienteDAO.getCliente(id));// AQUI uso uma API do Google que converte um ArrayList em JSON. Faço isso por que é melhor para tratar os dados no javascript/jquery
                try (PrintWriter out = response.getWriter()) {
                    out.println(json);
                }
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
