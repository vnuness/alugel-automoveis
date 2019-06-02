/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Avaliacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.RelatorioLocacao;

/**
 *
 * @author oem
 */
public class RelatorioLocacoesDAO {

    public static ArrayList<Avaliacao> getAvaliacoes() {
        ArrayList<Avaliacao> avaliacao = new ArrayList<Avaliacao>();

        String query = "SELECT * FROM avaliacao";

        try (Connection conn = ConnectionUtil.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Avaliacao lista = new Avaliacao();
                lista.setId(rs.getInt("id"));
                lista.setAvaliacao(rs.getString("nome"));
                avaliacao.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return avaliacao;
    }

    public static ArrayList<RelatorioLocacao> getLocacoes(String dateIni, String dateFim, int idAvaliacao, int idFilial) {
        ArrayList<RelatorioLocacao> relatorioLocacao = new ArrayList<RelatorioLocacao>();

        String query;

        if (idFilial != 4) {
            if (idAvaliacao == 0) {
                query = "SELECT * FROM relatorio_locacoes WHERE data_locacao BETWEEN '" + dateIni + "' AND '" + dateFim + "' AND id_filial = " + idFilial;
            } else {
                query = "SELECT * FROM relatorio_locacoes "
                        + "INNER JOIN avaliacao on relatorio_locacoes.avaliacao = avaliacao.nome "
                        + "WHERE data_locacao BETWEEN '" + dateIni + "' AND '" + dateFim + "' AND avaliacao.id = " + idAvaliacao + " AND id_filial = " + idFilial;
                System.out.println(query);
            }
        } else {
            if (idAvaliacao == 0) {
                query = "SELECT * FROM relatorio_locacoes WHERE data_locacao BETWEEN '" + dateIni + "' AND '" + dateFim + "'";
            } else {
                query = "SELECT * FROM relatorio_locacoes "
                        + "INNER JOIN avaliacao on relatorio_locacoes.avaliacao = avaliacao.nome "
                        + "WHERE data_locacao BETWEEN '" + dateIni + "' AND '" + dateFim + "' AND avaliacao.id = " + idAvaliacao + "";
                System.out.println(query);
            }
        }

        try (Connection conn = ConnectionUtil.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RelatorioLocacao lista = new RelatorioLocacao();
                lista.setCliente(rs.getString("cliente"));
                lista.setCategoriaCliente(rs.getString("categoria_cliente"));
                lista.setVeiculo(rs.getString("veiculo"));
                lista.setPlaca(rs.getString("placa"));
                lista.setValor(rs.getDouble("valor"));
                lista.setTipoDevolutiva(rs.getString("tipo_devolutiva"));
                lista.setAvaliacao(rs.getString("avaliacao"));
                lista.setDataLocacao(rs.getString("data_locacao"));
                lista.setDataDevolucao(rs.getString("data_devolucao"));
                //System.out.println(p.getData_cadastro());  
                relatorioLocacao.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }

        return relatorioLocacao;
    }
}
