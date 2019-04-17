package DAO;

/**
 *
 * @author Raphael Orlandi
 */
import Models.CategoriaCNH;
import Models.CategoriaCliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Cliente;
import Models.ListaCliente;
import Models.Sexo;
import Models.StatusClienteUsuario;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClienteDAO {

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

    public static boolean Salvar(Cliente c) throws ParseException {
        boolean retorno = false;

        Connection connection = null;
        try {
            connection = obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String data = dfUsa.format();
        //Date parsed = (Date) dfUsa.parse(data);

        if (c.getIdCategoriaCliente() == 2) {
            try {
                PreparedStatement Create = connection.prepareStatement(
                        "INSERT INTO cliente (nome, "
                        + " cpf_cnpj,"
                        + " cnh,"
                        + " id_categoria_cnh,"
                        + " email,"
                        + " validade_cnh,"
                        + " endereco,"
                        + " cep,"
                        + " bairro,"
                        + " complemento,"
                        + " cidade,"
                        + " estado,"
                        + " celular,"
                        + " id_categoria_cliente)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                Create.setString(1, c.getNome());
                Create.setString(2, c.getCpfCnpj());
                Create.setString(3, c.getCnh());
                Create.setInt(4, c.getIdcategoriacnh());
                Create.setString(5, c.getEmail());
                Create.setString(6, c.getDataNascimento());
                Create.setString(7, c.getEndereco());
                Create.setString(8, c.getCep());
                Create.setString(9, c.getBairro());
                Create.setString(10, c.getComplemento());
                Create.setString(11, c.getCidade());
                Create.setString(12, c.getEstado());
                Create.setString(13, c.getCelular());
                Create.setInt(14, c.getIdCategoriaCliente());

                int linhasAfetadas = Create.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                PreparedStatement Create = connection.prepareStatement(
                        "INSERT INTO cliente ("
                        + "nome,"
                        + "	cpf_cnpj,"
                        + "	id_sexo,"
                        + "	 id_categoria_cliente ,"
                        + "	 cnh ,"
                        + "	 id_categoria_cnh ,"
                        + "	 rg ,"
                        + "	 email ,"
                        + "	 nacionalidade ,"
                        + "	 data_nascimento ,"
                        + "	 validade_cnh ,"
                        + "	 cep ,"
                        + "	 endereco ,"
                        + "	 numero ,"
                        + "	 bairro ,"
                        + "	 complemento ,"
                        + "	 cidade ,"
                        + "	 estado ,"
                        + "	 celular)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                Create.setString(1, c.getNome());
                Create.setString(2, c.getCpfCnpj());
                Create.setInt(3, c.getIdsexo());
                Create.setInt(4, c.getIdCategoriaCliente());
                Create.setString(5, c.getCnh());
                Create.setInt(6, c.getIdcategoriacnh());
                Create.setString(7, c.getRg());
                Create.setString(8, c.getEmail());
                Create.setString(9, c.getNacionalidade());
                Create.setString(10, c.getDataNascimento());
                Create.setString(11, c.getValidadeCnh());
                Create.setString(12, c.getCep());
                Create.setString(13, c.getEndereco());
                Create.setInt(14, c.getNumero());
                Create.setString(15, c.getBairro());
                Create.setString(16, c.getComplemento());
                Create.setString(17, c.getCidade());
                Create.setString(18, c.getEstado());
                Create.setString(19, c.getCelular());

                int linhasAfetadas = Create.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retorno;
    }

    //implementar metodo inativar - recebe ID e realizar UPDATE no registro
    public static boolean Inativar(int id) {
        boolean retorno = false;
        try {
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE cliente SET "
                    + "id_status = 2 "
                    + "WHERE id = ?");
            Update.setInt(1, id);
            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static boolean Atualizar(Cliente c) {

        boolean retorno = false;
        try {
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE cliente SET "
                    + "NOME,"
                    + "CPF_CNPJ,"
                    + "ID_SEXO,"
                    + "CNH,"
                    + "ID_CATEGORIA_CNH,"
                    + "RG,"
                    + "EMAIL,"
                    + "NACIONALIDASE,"
                    + "DATA_NASCIMENTO,"
                    + "ENDERECO,"
                    + "CEP,"
                    + "BAIRRO,"
                    + "COMPLEMENTO,"
                    + "CIDADE,"
                    + "ESTADO,"
                    + "CELULAR,"
                    + "STATUS,"
                    + "ID_CATEGORIA_CLIENTE)"
                    + "WHERE ID = ");

            Update.setString(1, c.getNome());
            Update.setString(2, c.getCpfCnpj());
            Update.setInt(3, c.getIdsexo());
            Update.setString(4, c.getCnh());
            Update.setInt(5, c.getIdcategoriacnh());
            Update.setString(6, c.getRg());
            Update.setString(7, c.getEmail());
            Update.setString(8, c.getNacionalidade());
            Update.setString(9, c.getDataNascimento());
            Update.setString(10, c.getEndereco());
            Update.setString(11, c.getCep());
            Update.setString(12, c.getBairro());
            Update.setString(13, c.getComplemento());
            Update.setString(14, c.getCidade());
            Update.setString(15, c.getEstado());
            Update.setString(16, c.getCelular());
            Update.setInt(17, c.getStatus());
            Update.setInt(18, c.getIdCategoriaCliente());
            Update.setInt(19, c.getId());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static ArrayList<CategoriaCNH> getCategoriaCNH() {
        ArrayList<CategoriaCNH> listaCategoriaCNH = new ArrayList<CategoriaCNH>();

        String query = "SELECT * FROM categoria_cnh;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CategoriaCNH categoriaCnh = new CategoriaCNH();
                categoriaCnh.setId(rs.getInt("id"));
                categoriaCnh.setCategoria(rs.getString("Categoria"));
                listaCategoriaCNH.add(categoriaCnh);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaCategoriaCNH;
    }

    public static ArrayList<StatusClienteUsuario> getStatusClienteUsuarios() {
        ArrayList<StatusClienteUsuario> listaStatus = new ArrayList<StatusClienteUsuario>();

        String query = "SELECT * FROM STATUS_CLIENTE_USUARIO;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                StatusClienteUsuario status = new StatusClienteUsuario();
                status.setId(rs.getInt("id"));
                status.setStatus(rs.getString("status"));
                listaStatus.add(status);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaStatus;
    }

    public static ArrayList<Sexo> getSexo() {
        ArrayList<Sexo> listaSexo = new ArrayList<Sexo>();

        String query = "SELECT * FROM sexo;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Sexo sexo = new Sexo();
                sexo.setId(rs.getInt("id"));
                sexo.setSexo(rs.getString("sexo"));
                listaSexo.add(sexo);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaSexo;
    }

    public static ArrayList<CategoriaCliente> getCategoriaCliente() {
        ArrayList<CategoriaCliente> ListaCategoriaCliente = new ArrayList<CategoriaCliente>();

        String query = "SELECT * FROM CATEGORIA_CLIENTE;";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CategoriaCliente categoria_cliente = new CategoriaCliente();
                categoria_cliente.setId(rs.getInt("id"));
                categoria_cliente.setCategoria(rs.getString("Categoria"));
                ListaCategoriaCliente.add(categoria_cliente);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return ListaCategoriaCliente;
    }

    public static ArrayList<ListaCliente> getCliente(int id) {
        ArrayList<ListaCliente> listaClientes = new ArrayList<ListaCliente>();

        String query = "select "
                + "cliente.id, "
                + "nome, "
                + "categoria_cliente.categoria, "
                + "cpf_cnpj, "
                + "email, "
                + "`status_cliente_usuario`.`status` "
                + "from tades_locadora.cliente "
                + "INNER JOIN categoria_cliente ON cliente.id_categoria_cliente = categoria_cliente.id "
                + "INNER JOIN status_cliente_usuario ON cliente.id_status = status_cliente_usuario.id";
        if (id != 0) {
            query += " where cliente.id = " + id;
        }

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ListaCliente lista = new ListaCliente();
                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setCpfcnpj(rs.getString("cpf_cnpj"));
                lista.setEmail(rs.getString("email"));
                lista.setStatus(rs.getString("status"));
                lista.setCategoria(rs.getString("categoria"));
                listaClientes.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaClientes;
    }

}
