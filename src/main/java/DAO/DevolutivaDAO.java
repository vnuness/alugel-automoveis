/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cliente;
import Models.Devolutiva;
import Models.LocacaoPorCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FGO064
 */
public class DevolutivaDAO {

    public static boolean Salvar(Devolutiva d) {
        boolean retorno = false;

        Connection connection = null;
        try {
            connection = ConnectionUtil.obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement Create = connection.prepareStatement(
                    "INSERT INTO tades_locadora.devolutiva ("
                    + "id_cliente, "
                    + "id_avaliacao, "
                    + "id_tipo_devolutiva, "
                    + "id_locacao, "
                    + "observacao, "
                    + "id_filial) "
                    + "VALUES(?, ?, ?, ?, ?, ?);"
            );

            Create.setInt(1, d.getIdCliente());
            Create.setInt(2, d.getIdAvaliacao());
            Create.setInt(3, d.getIdTipoDevolutiva());
            Create.setInt(4, d.getIdLocacao());
            Create.setString(5, d.getObservacao());
            Create.setInt(6, d.getIdFilial());

            System.out.print(d.getIdLocacao());
            
            atualizarStatusLocacao(d.getIdLocacao());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static boolean atualizarStatusLocacao(int idLocacao) {
        boolean retorno = false;

        Connection connection = null;
        try {
            connection = ConnectionUtil.obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            PreparedStatement update = connection.prepareStatement("UPDATE tades_locadora.locacoes SET id_status_locacao = 2 WHERE id = " + idLocacao);

            int linhasAfetadas = update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static ArrayList<LocacaoPorCliente> getLocacaoByCliente(String cpf) {
        ArrayList<LocacaoPorCliente> listaLocacao = new ArrayList<LocacaoPorCliente>();

        String query = "SELECT "
                + "    cliente.id AS id_cliente, "
                + "    cliente.nome, "
                + "    locacoes.id AS id_locacao "
                + "FROM "
                + "    tades_locadora.cliente "
                + "INNER JOIN locacoes on locacoes.id_cliente = cliente.id "
                + "WHERE cliente.cpf_cnpj = '" + cpf + "' AND id_status_locacao = 1;";

        System.out.println(query);

        try (Connection conn = ConnectionUtil.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                LocacaoPorCliente locacao = new LocacaoPorCliente();
                locacao.setIdCliente(rs.getInt("id_cliente"));
                locacao.setNomeCliente(rs.getString("nome"));
                locacao.setIdLocacao(rs.getInt("id_locacao"));
                listaLocacao.add(locacao);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaLocacao;
    }
}
