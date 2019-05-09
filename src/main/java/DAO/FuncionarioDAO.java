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
import Models.ListaUsuarios;
import Models.Cargo;
import Models.Filial;

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
                    "INSERT INTO tades_locadora.usuarios ("
                    + "senha,"
                    + "matricula,"
                    + "id_filial,"
                    + "id_cargo,"
                    + "nome,"
                    + "email)"
                    + "VALUES (?, ?, ?, ?, ?, ?)"
            );
            Create.setString(1, f.getSenha());
            Create.setString(2, f.getMatricula());
            Create.setInt(3, f.getIdFilial());
            Create.setInt(4, f.getIdCargo());
            Create.setString(5, f.getNome());
            Create.setString(6, f.getEmail());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static ArrayList<ListaUsuarios> getUsuarios(int id) {
        ArrayList<ListaUsuarios> listaClientes = new ArrayList<ListaUsuarios>();

        String query = "SELECT "
                + "usuarios.id, "
                + "usuarios.matricula, "
                + "usuarios.email, "
                + "usuarios.nome, "
                + "cargo.cargo, "
                + "filial.filial, "
                + "usuarios.data_cadastro "
                + " FROM tades_locadora.usuarios "
                + "INNER JOIN filial on filial.id = usuarios.id_filial "
                + "INNER JOIN cargo on cargo.id = usuarios.id_cargo "
                + "WHERE usuarios.id_status = 1";
        if (id != 0) {
            query = "SELECT id, matricula, email, senha, nome, id_cargo as cargo, id_filial as filial, data_cadastro FROM usuarios where id = " + id;
        }

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ListaUsuarios lista = new ListaUsuarios();
                lista.setId(rs.getInt("id"));
                lista.setMatricula(rs.getString("matricula"));
                lista.setEmail(rs.getString("email"));
                lista.setNome(rs.getString("nome"));
                lista.setCargo(rs.getString("cargo"));
                lista.setFilial(rs.getString("filial"));
                lista.setDataCadastro(rs.getString("data_cadastro"));
                listaClientes.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaClientes;
    }

    public static boolean Atualizar(Funcionario f) {

        boolean retorno = false;
        try {
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE tades_locadora.funcionario SET "
                    + "senha = ?, "
                    + "matricula = ?, "
                    + "id_filial = ?,"
                    + "id_cargo = ?,"
                    + "nome = ? "
                    + "email = ? "
                    + "WHERE ID = " + f.getId());

            Update.setString(1, f.getSenha());
            Update.setString(2, f.getMatricula());
            Update.setInt(3, f.getIdFilial());
            Update.setInt(4, f.getIdCargo());
            Update.setString(5, f.getNome());
            Update.setString(6, f.getEmail());

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
    
    public static ArrayList<Cargo> getCargo() {
        ArrayList<Cargo> listaCargo = new ArrayList<Cargo>();

        String query = "SELECT * FROM cargo;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId(rs.getInt("id"));
                cargo.setCargo(rs.getString("cargo"));
                listaCargo.add(cargo);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaCargo;
    }
    
    public static ArrayList<Filial> getFilial() {
        ArrayList<Filial> listaFilial = new ArrayList<Filial>();

        String query = "SELECT * FROM filial;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Filial filial = new Filial();
                filial.setId(rs.getInt("id"));
                filial.setFilial(rs.getString("filial"));
                listaFilial.add(filial);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaFilial;
    }

    public static boolean Desativar(int id) {
        boolean retorno = false;
        try {
            System.out.println(id);
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE usuarios SET id_status = 2 "
                    + "WHERE id = ?");
            
            Update.setInt(1, id);
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
