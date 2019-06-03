package DAO;

import Models.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class LocacaoDAO {
    
    public static boolean salvar(Locacao l) {
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