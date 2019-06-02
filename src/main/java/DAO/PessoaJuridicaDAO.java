/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class PessoaJuridicaDAO implements PadraoDAO {

    @Override
    public boolean salvar(Object x) throws ParseException {
        PessoaJuridica pj = (PessoaJuridica) x;

        boolean retorno = false;

        Connection connection = null;
        try {
            connection = ConnectionUtil.obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement Create = connection.prepareStatement(
                    "INSERT INTO cliente (nome, "
                    + " cpf_cnpj,"
                    + " cnh,"
                    + " id_categoria_cnh,"
                    + " email,"
                    + " validade_cnh,"
                    + " endereco,"
                    + " cep,"
                    + " bairro,"
                    + " complemento,"
                    + " cidade,"
                    + " estado,"
                    + " celular,"
                    + " numero,"
                    + " id_categoria_cliente)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            Create.setString(1, pj.getNome());
            Create.setString(2, pj.getCnpj());
            Create.setString(3, pj.getCnh());
            Create.setInt(4, pj.getIdCategoriaCnh());
            Create.setString(5, pj.getEmail());
            Create.setString(6, pj.getValidadeCnh());
            Create.setString(7, pj.getEndereco());
            Create.setString(8, pj.getCep());
            Create.setString(9, pj.getBairro());
            Create.setString(10, pj.getComplemento());
            Create.setString(11, pj.getCidade());
            Create.setString(12, pj.getEstado());
            Create.setString(13, pj.getCelular());
            Create.setInt(14, pj.getNumero());
            Create.setInt(15, pj.getIdCategoriaCliente());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    @Override
    public boolean atualizar(Object x) {
        PessoaJuridica pj = (PessoaJuridica) x;

        boolean retorno = false;
        try {
            Connection Conexao = ConnectionUtil.obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE cliente SET "
                    + "nome = ?, "
                    + "cpf_cnpj = ?, "
                    + "cnh = ?, "
                    + "id_categoria_cnh = ?, "
                    + "email = ?, "
                    + "validade_cnh = ?, "
                    + "cep = ?, "
                    + "endereco = ?, "
                    + "numero = ?, "
                    + "bairro = ?, "
                    + "complemento = ?, "
                    + "cidade = ?,"
                    + "estado = ?, "
                    + "celular = ? "
                    + "WHERE id = ?");

            Update.setString(1, pj.getNome());
            Update.setString(2, pj.getCnpj());
            Update.setString(3, pj.getCnh());
            Update.setInt(4, pj.getIdCategoriaCnh());
            Update.setString(5, pj.getEmail());
            Update.setString(6, pj.getValidadeCnh());
            Update.setString(7, pj.getCep());
            Update.setString(8, pj.getEndereco());
            Update.setInt(9, pj.getNumero());
            Update.setString(10, pj.getBairro());
            Update.setString(11, pj.getComplemento());
            Update.setString(12, pj.getCidade());
            Update.setString(13, pj.getEstado());
            Update.setString(14, pj.getCelular());
            Update.setInt(15, pj.getId());

            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

}
