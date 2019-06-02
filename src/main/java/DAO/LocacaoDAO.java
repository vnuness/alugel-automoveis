package DAO;

import Models.Locacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class LocacaoDAO {
    
    public static boolean Salvar(Locacao l) {
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
                    "INSERT INTO locacoes (`id_cliente`, `id_veiculo`, `valor`, `obs`, `id_filial`) VALUES (" + l.getIdCliente() + ", " + l.getIdVeiculo() +  ", '" + l.getValor() + "', '" + l.getObs() + "', '" + l.getIdFilial() + "');");
            
//            String query = "INSERT INTO tades_locadora.locacoes ("
//                    + "id_cliente,"
//                    + "id_veiculo,"
//                    + "valor,"
//                    + "obs)"
//                    + "VALUES (?, ?, ?, ?);";
//            
//            System.out.println(query);

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