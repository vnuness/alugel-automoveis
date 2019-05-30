package DAO;

/**
 *
 * @author Raphael Orlandi
 */
import Models.CategoriaCNH;
import Models.CategoriaCliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Cliente;
import Models.ListaCliente;
import Models.Sexo;
import Models.StatusClienteUsuario;

import java.text.ParseException;

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

    public static boolean salvar(Cliente c) throws ParseException {
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
                        + " numero,"
                        + " id_categoria_cliente)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
                Create.setInt(14, c.getNumero());
                Create.setInt(15, c.getIdCategoriaCliente());

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

    public static boolean ativar(int id) {
        boolean retorno = false;
        try {
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE cliente SET "
                    + "id_status = 1 "
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

    public static boolean atualizar(Cliente c) {

        boolean retorno = false;

        if (c.getIdCategoriaCliente() == 2) {
            try {
                Connection Conexao = obterConexao();

                PreparedStatement Update = Conexao.prepareStatement(
                        "UPDATE cliente SET "
                        + "nome = ?,"
                        + "cpf_cnpj = ?,"
                        + "cnh = ?,"
                        + "id_categoria_cnh = ?,"
                        + "email = ?,"
                        + "validade_cnh = ?"
                        + "cep = ?,"
                        + "endereco = ?,"
                        + "numero = ?,"
                        + "bairro = ?,"
                        + "complemento = ?,"
                        + "cidade = ?,"
                        + "estado = ?,"
                        + "celular = ?)"
                        + "WHERE id = ?");

                Update.setString(1, c.getNome());
                Update.setString(2, c.getCpfCnpj());
                Update.setString(3, c.getCnh());
                Update.setInt(4, c.getIdCategoriaCnh());
                Update.setString(5, c.getEmail());
                Update.setString(6, c.getValidadeCnh());
                Update.setString(7, c.getCep());
                Update.setString(8, c.getEndereco());
                Update.setInt(9, c.getNumero());
                Update.setString(10, c.getBairro());
                Update.setString(11, c.getComplemento());
                Update.setString(12, c.getCidade());
                Update.setString(13, c.getEstado());
                Update.setString(14, c.getCelular());
                Update.setInt(15, c.getId());

                int linhasAfetadas = Update.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Connection Conexao = obterConexao();

                PreparedStatement Update = Conexao.prepareStatement(
                        "UPDATE `tades_locadora`.`cliente` "
                        + "SET "
                        + "`nome` = ?, "
                        + "`cpf_cnpj` = ?, "
                        + "`id_sexo` = ?, "
                        + "`id_categoria_cliente` = ?, "
                        + "`cnh` = ?, "
                        + "`id_categoria_cnh` = ?, "
                        + "`rg` = ?, "
                        + "`email` = ?, "
                        + "`nacionalidade` = ?, "
                        + "`data_nascimento` = ?, "
                        + "`validade_cnh` = ?, "
                        + "`cep` = ?, "
                        + "`endereco` = ?, "
                        + "`numero` = ?, "
                        + "`bairro` = ?, "
                        + "`complemento` = ?, "
                        + "`cidade` = ?, "
                        + "`estado` = ?, "
                        + "`celular` = ? "
                        + "WHERE `id` = ?;");

                Update.setString(1, c.getNome());
                Update.setString(2, c.getCpfCnpj());
                Update.setInt(3, c.getIdsexo());
                Update.setInt(4, c.getIdCategoriaCliente());
                Update.setString(5, c.getCnh());
                Update.setInt(6, c.getIdCategoriaCnh());
                Update.setString(7, c.getRg());
                Update.setString(8, c.getEmail());
                Update.setString(9, c.getNacionalidade());
                Update.setString(10, c.getDataNascimento());
                Update.setString(11, c.getValidadeCnh());
                Update.setString(12, c.getCep());
                Update.setString(13, c.getEndereco());
                Update.setInt(14, c.getNumero());
                Update.setString(15, c.getBairro());
                Update.setString(16, c.getComplemento());
                Update.setString(17, c.getCidade());
                Update.setString(18, c.getEstado());
                Update.setString(19, c.getCelular());
                Update.setInt(20, c.getId());

                int linhasAfetadas = Update.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public static ArrayList<Cliente> getClienteById(int id) {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        String query = "select * from cliente where id = " + id;

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpfCnpj(rs.getString("cpf_cnpj"));
                c.setIdsexo(rs.getInt("id_sexo"));
                c.setIdCategoriaCliente(rs.getInt("id_categoria_cliente"));
                c.setCnh(rs.getString("cnh"));
                c.setIdCategoriaCnh(rs.getInt("id_categoria_cnh"));
                c.setRg(rs.getString("rg"));
                c.setEmail(rs.getString("email"));
                c.setNacionalidade(rs.getString("nacionalidade"));
                c.setDataNascimento(rs.getString("data_nascimento"));
                c.setValidadeCnh(rs.getString("validade_cnh"));
                c.setCep(rs.getString("cep"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setComplemento(rs.getString("complemento"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setCelular(rs.getString("celular"));
                listaCliente.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaCliente;

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

    public static ArrayList<Cliente> getClienteCpf(String cpf) {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        int numeroLinhas = 0;

        String verificaLocacao = "SELECT * FROM cliente inner join locacoes on cliente.id = locacoes.id_cliente where cliente.cpf_cnpj = '" + cpf + "' AND locacoes.id_status_locacao = 1;";
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(verificaLocacao);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                numeroLinhas = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (numeroLinhas > 0) {
            return listaCliente;
        }

        String query = "SELECT * FROM cliente where cpf_cnpj = '" + cpf + "';";

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setIdCategoriaCliente(rs.getInt("id_categoria_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCnh(rs.getString("cnh"));
                cliente.setValidadeCnh(rs.getString("validade_cnh"));
                listaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaCliente;
    }

}
