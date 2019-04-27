/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
    
    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        // 1) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2) Abrir a conexão
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tades_locadora?useTimezone=true&serverTimezone=UTC",
                "root",
                "");
        return conn;
    }
    
    //public static 
    
    public static ArrayList<RelatorioLocacao> getLocacoes() {
        ArrayList<RelatorioLocacao> relatorioLocacao = new ArrayList<RelatorioLocacao>();

        String query = "SELECT * FROM relatorio_locacoes";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RelatorioLocacao lista = new RelatorioLocacao();
                lista.setCliente(rs.getString("cliente"));
                lista.setCategoriaCliente(rs.getString("categoria_cliente"));
                lista.setVeiculo(rs.getString("veiculo"));
                lista.setPlaca(rs.getString("placa"));
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
            ex.printStackTrace();
        }

        return relatorioLocacao;
    }
}
