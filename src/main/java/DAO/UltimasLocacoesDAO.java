/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.UltimasLocacoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class UltimasLocacoesDAO {
    
    public static ArrayList<UltimasLocacoes> getUltimasLocacoes(int idFilial) {
        ArrayList<UltimasLocacoes> ultimasLocacoes = new ArrayList<UltimasLocacoes>();

        String query;
        
        if(idFilial != 4) {
            query = "SELECT * FROM ultimas_locacoes where id_filial = " + idFilial;
        } else {
            query = "SELECT * FROM ultimas_locacoes";
        }

        try (Connection conn = ConnectionUtil.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                UltimasLocacoes lista = new UltimasLocacoes();
                lista.setCliente(rs.getString("cliente"));
                lista.setDataLocacao(rs.getString("data_locacao"));
                lista.setDataDevolucao(rs.getString("data_devolucao"));
                lista.setAvaliacao(rs.getString("avaliacao"));
                ultimasLocacoes.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }

        return ultimasLocacoes;
    }
}
