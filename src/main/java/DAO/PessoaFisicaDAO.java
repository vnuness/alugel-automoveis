/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oem
 */
public class PessoaFisicaDAO implements PadraoDAO {

    @Override
    public boolean salvar(Object x) throws ParseException {
        PessoaFisica pf = (PessoaFisica) x;
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
                    "INSERT INTO cliente ("
                    + "nome,"
                    + "	cpf_cnpj,"
                    + "	id_sexo,"
                    + "	 id_categoria_cliente ,"
                    + "	 cnh ,"
                    + "	 id_categoria_cnh ,"
                    + "	 rg ,"
                    + "	 email ,"
                    + "	 nacionalidade ,"
                    + "	 data_nascimento ,"
                    + "	 validade_cnh ,"
                    + "	 cep ,"
                    + "	 endereco ,"
                    + "	 numero ,"
                    + "	 bairro ,"
                    + "	 complemento ,"
                    + "	 cidade ,"
                    + "	 estado ,"
                    + "	 celular)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            Create.setString(1, pf.getNome());
            Create.setString(2, pf.getCpf());
            Create.setInt(3, pf.getIdSexo());
            Create.setInt(4, pf.getIdCategoriaCliente());
            Create.setString(5, pf.getCnh());
            Create.setInt(6, pf.getIdCategoriaCnh());
            Create.setString(7, pf.getRg());
            Create.setString(8, pf.getEmail());
            Create.setString(9, pf.getNacionalidade());
            Create.setString(10, pf.getDataNascimento());
            Create.setString(11, pf.getValidadeCnh());
            Create.setString(12, pf.getCep());
            Create.setString(13, pf.getEndereco());
            Create.setInt(14, pf.getNumero());
            Create.setString(15, pf.getBairro());
            Create.setString(16, pf.getComplemento());
            Create.setString(17, pf.getCidade());
            Create.setString(18, pf.getEstado());
            Create.setString(19, pf.getCelular());

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
        PessoaFisica pf = (PessoaFisica) x;
        boolean retorno = false;

        try {
            Connection Conexao = ConnectionUtil.obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE `tades_locadora`.`cliente` "
                    + "SET "
                    + "`nome` = ?, "
                    + "`cpf_cnpj` = ?, "
                    + "`id_sexo` = ?, "
                    + "`id_categoria_cliente` = ?, "
                    + "`cnh` = ?, "
                    + "`id_categoria_cnh` = ?, "
                    + "`rg` = ?, "
                    + "`email` = ?, "
                    + "`nacionalidade` = ?, "
                    + "`data_nascimento` = ?, "
                    + "`validade_cnh` = ?, "
                    + "`cep` = ?, "
                    + "`endereco` = ?, "
                    + "`numero` = ?, "
                    + "`bairro` = ?, "
                    + "`complemento` = ?, "
                    + "`cidade` = ?, "
                    + "`estado` = ?, "
                    + "`celular` = ? "
                    + "WHERE `id` = ?;");

            Update.setString(1, pf.getNome());
            Update.setString(2, pf.getCpf());
            Update.setInt(3, pf.getIdSexo());
            Update.setInt(4, pf.getIdCategoriaCliente());
            Update.setString(5, pf.getCnh());
            Update.setInt(6, pf.getIdCategoriaCnh());
            Update.setString(7, pf.getRg());
            Update.setString(8, pf.getEmail());
            Update.setString(9, pf.getNacionalidade());
            Update.setString(10, pf.getDataNascimento());
            Update.setString(11, pf.getValidadeCnh());
            Update.setString(12, pf.getCep());
            Update.setString(13, pf.getEndereco());
            Update.setInt(14, pf.getNumero());
            Update.setString(15, pf.getBairro());
            Update.setString(16, pf.getComplemento());
            Update.setString(17, pf.getCidade());
            Update.setString(18, pf.getEstado());
            Update.setString(19, pf.getCelular());
            Update.setInt(20, pf.getId());

            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
