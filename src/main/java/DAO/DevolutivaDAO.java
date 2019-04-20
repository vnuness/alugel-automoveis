/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Devolutiva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FGO064
 */
public class DevolutivaDAO {
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
        
        public static boolean Salvar(Devolutiva d) {
        boolean retorno = false;

        Connection connection = null;
        try {
            connection = obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement Create = connection.prepareStatement(
                    "INSERT INTO tades_locadora.devolutiva ("
                    + "id_cliente,"
                    + "id_avaliacao,"
                    + "id_tipo_devolutiva,"
                    + "id_status_locacao,"
                    + "data_devolucao,"
                    + "VALUES (?, ?, ?, ?, ?)"
                    );

            Create.setInt(1, d.getId_cliente());
            Create.setInt(2, d.getId_avaliacao());
            Create.setInt(3, d.getId_tipo_devolutiva());
            Create.setInt(4, d.getId_status_locacao());
            Create.setDate(5, (Date) d.getData_devolucao());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
