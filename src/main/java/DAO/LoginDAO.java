/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Funcionario;
import Models.Login;
import java.sql.Connection;
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
    
    public static boolean login(Login credenciais) throws SQLException
    {
        boolean retorno = false;
        Connection connection = null;
        try {
            connection = ConnectionUtil.obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PreparedStatement stmt = connection.prepareStatement("select * from usuarios where email = ? and senha = MD5(?)");
        stmt.setString(1, credenciais.getEmail());
        stmt.setString(2, credenciais.getSenha());
        
        int numeroLinhas = 0;
        
        try (ResultSet rs = stmt.executeQuery()) {
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

        try (Connection conn = ConnectionUtil.obterConexao();
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
