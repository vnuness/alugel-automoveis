package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Funcionario;
import Models.Veiculo;
import java.sql.Date;

/**
 *
 * @author FGO064
 */
public class FuncionarioDAO {
 
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
    
        public static boolean Salvar(Funcionario f) {
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
                    "INSERT INTO tades_locadora.funcionario ("
                    + "USUARIO,"
                    + "SENHA,"
                    + "MATRICULA,"
                    + "ID_FILIAL,"
                    + "ID_CARGO,"
                    + "NOME,"
                    + "EMAIL,"
                    + "STATUS)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    );

            Create.setString(1, f.getUsuario());
            Create.setString(2, f.getSenha());
            Create.setInt(3, f.getMatricula());
            Create.setInt(4, f.getId_filial());
            Create.setInt(5, f.getId_cargo());
            Create.setString(6, f.getNome());
            Create.setString(7, f.getEmail());
            Create.setInt(8, f.getId_status());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
        
         public static boolean Atualizar(Funcionario f) {

        boolean retorno = false;
        try {
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE tades_locadora.funcionario SET "
                    + "USUARIO = ?, "
                    + "SENHA = ?, "
                    + "MATRICULA = ?, "
                    + "ID_FILIAL = ?,"
                    + "ID_CARGO = ?,"
                    + "NOME = ? "
                    + "EMAIL = ? "
                    + "STATUS = ? "        
                    + "WHERE ID = " + f.getId());

             Update.setString(1, f.getUsuario());
             Update.setString(2, f.getSenha());
             Update.setInt(3, f.getMatricula());
             Update.setInt(4, f.getId_filial());
             Update.setInt(5, f.getId_cargo());
             Update.setString(6, f.getNome());
             Update.setString(7, f.getEmail());
             Update.setInt(8, f.getId_status());
             
            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }
         
             public static boolean Desativar(int id) {
        boolean retorno = false;
        try {
            System.out.println(id);
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    
                    "UPDATE tades_locadora.funcionario SET "
                    + "STATUS = 2"
                    + "WHERE ID = " + id);

            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        }
             

}
