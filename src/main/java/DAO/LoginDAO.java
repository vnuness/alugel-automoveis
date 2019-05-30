/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Funcionario;
import Models.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedrocruz
 */
public class LoginDAO {
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
    
    public static boolean login(Login credenciais) throws SQLException
    {
        boolean retorno = false;
        Connection connection = null;
        try {
            connection = obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query = "select * from usuarios where email = '" + credenciais.getEmail() + "' and senha = '" + credenciais.getSenha() + "'";
        
        System.out.println(query);
        
        int numeroLinhas = 0;
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
//            stmt.setString(1, credenciais.getEmail());
//            stmt.setString(2, credenciais.getSenha());
            while (rs.next()) {
                numeroLinhas = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if(numeroLinhas > 0 ) {
            return true;
        } 
        
        return retorno;
        
    }
    
    public static ArrayList<Funcionario> getInfoUsuario(String email) {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

        String query = "SELECT * FROM usuarios where email = '" + email + "'";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdFilial(rs.getInt("id_filial"));
                funcionario.setIdCargo(rs.getInt("id_cargo"));
                listaFuncionario.add(funcionario);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaFuncionario;
    }
}
