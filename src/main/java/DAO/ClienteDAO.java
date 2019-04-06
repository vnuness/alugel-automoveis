package DAO;

/**
 *
 * @author vsilva
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

    public static boolean Salvar(Cliente c) {
        boolean retorno = false;

        Connection connection = null;
        try {
            connection = obterConexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement Create = connection.prepareStatement(
                    "INSERT INTO cliente ("
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
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            Create.setString(1, c.getNome());
            Create.setString(2, c.getCpfcnpj());
            Create.setInt(3, c.getIdsexo());
            Create.setString(4, c.getCnh());
            Create.setInt(5, c.getIdcategoriacnh());
            Create.setString(6, c.getRg());
            Create.setString(7, c.getEmail());
            Create.setString(8, c.getNacionalidade());
            Create.setDate(9, (Date) c.getDatanascimento()); //duvida, tem que ficar assim para data???
            Create.setString(10, c.getEndereco());
            Create.setString(11, c.getCep());
            Create.setString(12, c.getBairro());
            Create.setString(13, c.getComplemento());
            Create.setString(14, c.getCidade());
            Create.setString(15, c.getEstado());
            Create.setString(16, c.getCelular());
            Create.setString(17, c.getStatus());
            Create.setInt(18, c.getIdCategoriaCliente());

            int linhasAfetadas = Create.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    + "id_status_cliente = 2"
                    + "WHERE ID = " + id);
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
            Update.setString(2, c.getCpfcnpj());
            Update.setInt(3, c.getIdsexo());
            Update.setString(4, c.getCnh());
            Update.setInt(5, c.getIdcategoriacnh());
            Update.setString(6, c.getRg());
            Update.setString(7, c.getEmail());
            Update.setString(8, c.getNacionalidade());
            Update.setDate(9, (Date) c.getDatanascimento()); //duvida, tem que ficar assim para data???
            Update.setString(10, c.getEndereco());
            Update.setString(11, c.getCep());
            Update.setString(12, c.getBairro());
            Update.setString(13, c.getComplemento());
            Update.setString(14, c.getCidade());
            Update.setString(15, c.getEstado());
            Update.setString(16, c.getCelular());
            Update.setString(17, c.getStatus());
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

        String query = "SELECT * FROM CATEGORIA_CNH;";

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

        String query = "SELECT * FROM SEXO;";

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

        String query = "";
        if (id != 0) {
            query = "SELECT * FROM cliente where id = " + id;
        } else {
            query = "SELECT \n"
                    + "	cliente.id, \n"
                    + "	cliente.nome, \n"
                    + "	cliente.cpfcnpj, \n"
                    + "	cliente.idsexo, \n"
                    + "	cliente.cnh, \n"
                    + "	cliente.idcategoriacnh,\n"
                    + "	cliente.rg,\n"
                    + "	cliente.email,\n"
                    + "	cliente.nacionalidade,\n"
                    + "	cliente.datanascimento,\n"
                    + "	cliente.endereco,\n"
                    + "	cliente.cep,\n"
                    + "	cliente.bairro,\n"
                    + "	cliente.complemento,\n"
                    + "	cliente.cidade,\n"
                    + "	cliente.estado,\n"
                    + "	cliente.celular,\n"
                    + " categoria_cnh.categoria_cnh, \n"
                    + " status_cliente_usuario.status,\n"
                    + " sexo.sexo, \n"
                    + " categoria_cliente.categoria, \n"
                    
                    + "	INNER JOIN `categoria_cnh` ON `clientes`.id_categoria_cnh = `categoria_cnh`.id \n"
                    + "	INNER JOIN `Status_cliente_usuario` ON `clientes`.status = `status_cliente_usuario`.id \n"
                    + "	INNER JOIN `sexo` ON `clientes`.id_sexo = `sexo`.id \n"
                    + "	INNER JOIN `categoria_cleinte` ON `clientes`.id_categoria_cliente = `categoria_cliente`.id";

        }

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ListaCliente lista = new ListaCliente();
                lista.setId(rs.getInt("id"));
                lista.setNome(rs.getString("nome"));
                lista.setCpfcnpj(rs.getString("CPF/CNPJ"));
                lista.setIdsexo(rs.getInt("Sexo"));
//                lista.setModelo(rs.getString("modelo"));
//                lista.setMontadora(rs.getString("montadora"));
//                lista.setAno(rs.getInt("ano"));
//                lista.setPlaca(rs.getString("placa"));
//                lista.setRenavam(rs.getString("renavam"));
//                if (id != 0) {
//                    lista.setCombustivel(rs.getString("id_combustivel"));
//                    lista.setCambio(rs.getString("id_cambio"));
//                    lista.setStatus(rs.getString("id_status"));
//                } else {
//                    lista.setCombustivel(rs.getString("combustivel"));
//                    lista.setCambio(rs.getString("cambio"));
//                    lista.setStatus(rs.getString("status"));
//                }
//                lista.setAcessorio(rs.getString("acessorios"));
                //System.out.println(p.getData_cadastro());  
                listaClientes.add(lista);
                ListaVeiculos lista = new ListaVeiculos();
                lista.setId(rs.getInt("id"));
                lista.setModelo(rs.getString("modelo"));
                lista.setMontadora(rs.getString("montadora"));
                lista.setAno(rs.getInt("ano"));
                lista.setPlaca(rs.getString("placa"));
                lista.setRenavam(rs.getString("renavam"));
                if (id != 0) {
                    lista.setCombustivel(rs.getString("id_combustivel"));
                    lista.setCambio(rs.getString("id_cambio"));
                    lista.setStatus(rs.getString("id_status"));
                } else {
                    lista.setCombustivel(rs.getString("combustivel"));
                    lista.setCambio(rs.getString("cambio"));
                    lista.setStatus(rs.getString("status"));
                }
                lista.setAcessorio(rs.getString("acessorios"));
                //System.out.println(p.getData_cadastro());  
                listaVeiculos.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return listaClientes;
    }
   
}
