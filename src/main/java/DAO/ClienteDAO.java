package DAO;

/**
 *
 * @author vsilva
 */
import Models.CategoriaCNH;
import Models.CategoriaCliente;
import Models.CambioVeiculo;
import Models.CombustivelVeiculo;
import Models.ListaVeiculos;
import Models.StatusVeiculo;
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
                    "INSERT INTO tades_locadora.cliente ("
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
                    + "CELULAR)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            Create.setString(1, c.getNome());
            Create.setString(2, c.getCpf_cnpj());
            Create.setInt(3, c.getId_sexo());
            Create.setString(4, c.getCnh());
            Create.setInt(5, c.getId_categoria_cnh());
            Create.setString(6, c.getRg());
            Create.setString(7, c.getEmail());
            Create.setString(8, c.getNacionalidade());
            Create.setDate(9, (Date) c.getData_nascimento()); //duvida, tem que ficar assim para data???
            Create.setString(10, c.getEndereco());
            Create.setString(11, c.getCep());
            Create.setString(12, c.getBairro());
            Create.setString(13, c.getComplemento());
            Create.setString(14, c.getCidade());
            Create.setString(15, c.getEstado());
            Create.setString(16, c.getCelular());

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
                    "UPDATE tades_locadora.cliente SET "
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
                    "UPDATE tades_locadora.cliente SET "
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
                    + "CELULAR)"
                    + "WHERE ID = ");

            Update.setString(1, c.getNome());
            Update.setString(2, c.getCpf_cnpj());
            Update.setInt(3, c.getId_sexo());
            Update.setString(4, c.getCnh());
            Update.setInt(5, c.getId_categoria_cnh());
            Update.setString(6, c.getRg());
            Update.setString(7, c.getEmail());
            Update.setString(8, c.getNacionalidade());
            Update.setDate(9, (Date) c.getData_nascimento()); //duvida, tem que ficar assim para data???
            Update.setString(10, c.getEndereco());
            Update.setString(11, c.getCep());
            Update.setString(12, c.getBairro());
            Update.setString(13, c.getComplemento());
            Update.setString(14, c.getCidade());
            Update.setString(15, c.getEstado());
            Update.setString(16, c.getCelular());
            Update.setInt(17, c.getId());

    }

    public static boolean Excluir(int id) {
        boolean retorno = false;
        try {
            System.out.println(id);
            Connection Conexao = obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "DELETE FROM veiculo WHERE ID = " + id);

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

   

    public static ArrayList<StatusClienteUsuario> getStatus_Cliente_Usuarios() {
        ArrayList<StatusClienteUsuario> listaStatus = new ArrayList<StatusClienteUsuario>();

        String query = "SELECT * FROM STATUS_CLIENTE_USUARIO;";

    }
    
    public static ArrayList<StatusVeiculo> getStatus() {
        ArrayList<StatusVeiculo> listaStatus = new ArrayList<StatusVeiculo>();
        
        String query = "SELECT * FROM STATUS_VEICULO;";
        
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

    public static ArrayList<CategoriaCNH> getCategoria_CNH() {
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
                CombustivelVeiculo combustivel = new CombustivelVeiculo();
                combustivel.setId(rs.getInt("id"));
                combustivel.setCombustivel(rs.getString("combustivel"));
                listaCombustivel.add(combustivel);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaCategoriaCNH;
    }

    public static ArrayList<CategoriaCliente> getCategoria_Cliente() {
        ArrayList<CategoriaCliente> ListaCategoriaCliente = new ArrayList<CategoriaCliente>();

        String query = "SELECT * FROM CATEGORIA_CLIENTE;";

        return listaCombustivel;
    }
    
    public static ArrayList<CambioVeiculo> getCambio() {
        ArrayList<CambioVeiculo> listaCambio = new ArrayList<CambioVeiculo>();
        
        String query = "SELECT * FROM CAMBIO;";
        
        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CategoriaCliente categoria_cliente = new CategoriaCliente();
                categoria_cliente.setId(rs.getInt("id"));
                categoria_cliente.setCategoria(rs.getString("Categoria"));
                ListaCategoriaCliente.add(categoria_cliente);
                CambioVeiculo cambio = new CambioVeiculo();
                cambio.setId(rs.getInt("id"));
                cambio.setCambio(rs.getString("cambio"));
                listaCambio.add(cambio);
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
                    + "	cliente.cpf_cnpj, \n"
                    + "	cliente.id_sexo, \n"
                    + "	cliente.cnh, \n"
                    + "	cliente.id_categoria_cnh,\n"
                    + "	cliente.rg,\n"
                    + "	cliente.email,\n"
                    + "	cliente.nacionalidade,\n"
                    + "	cliente.data_nascimento,\n"
                    + "	cliente.endereco,\n"
                    + "	cliente.cep,\n"
                    + "	cliente.bairro,\n"
                    + "	cliente.complemento,\n"
                    + "	cliente.cidade,\n"
                    + "	cliente.estado,\n"
                    + "	cliente.celular,\n"
                    + "	.rg,\n"
                    
                    //???
                    + "	cambio.cambio,\n"
                    + "	`status_Cliente_Usuario`.status,\n"
        return listaCambio;
    }

    public static ArrayList<ListaVeiculos> getVeiculos(int id) {
        ArrayList<ListaVeiculos> listaVeiculos = new ArrayList<ListaVeiculos>();

        String query = "";
        if (id != 0) {
            query = "SELECT * FROM veiculo where id = " + id;
        } else {
            query = "SELECT \n"
                    + "	veiculo.id, \n"
                    + "	veiculo.modelo, \n"
                    + "	veiculo.montadora, \n"
                    + "	veiculo.ano, \n"
                    + "	veiculo.placa, \n"
                    + "	veiculo.renavam,\n"
                    + "	combustivel.combustivel,\n"
                    + "	cambio.cambio,\n"
                    + "	`status_veiculo`.status,\n"
                    + "	veiculo.acessorios FROM veiculo\n"
                    + "	INNER JOIN `combustivel` ON `combustivel`.id = `veiculo`.id_combustivel\n"
                    + "	INNER JOIN `status_veiculo` ON `status_veiculo`.id = `veiculo`.id_status\n"
                    + "	INNER JOIN `cambio` ON `cambio`.id = `veiculo`.id_cambio";
        }

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ListaCliente lista = new ListaCliente();
                lista.setId(rs.getInt("id"));
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
    //public static ArrayList<ListaVeiculos> getVeiculos(int id) {
}
