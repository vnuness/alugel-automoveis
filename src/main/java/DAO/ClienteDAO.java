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
import Models.ListaCliente;
import Models.Sexo;
import Models.Cliente;
import Models.StatusClienteUsuario;

public class ClienteDAO {
    
    public static boolean Inativar(int id) {
        boolean retorno = false;
        try {
            Connection Conexao = ConnectionUtil.obterConexao();

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
            Connection Conexao = ConnectionUtil.obterConexao();

            PreparedStatement Update = Conexao.prepareStatement(
                    "UPDATE cliente SET "
                    + "id_status = 1 "
                    + "WHERE id = ?");
            Update.setInt(1, id);
            int linhasAfetadas = Update.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public static ArrayList<CategoriaCNH> getCategoriaCNH() {
        ArrayList<CategoriaCNH> listaCategoriaCNH = new ArrayList<CategoriaCNH>();

        String query = "SELECT * FROM categoria_cnh;";

        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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
        try (Connection conn = ConnectionUtil.obterConexao();
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

        try (Connection conn = ConnectionUtil.obterConexao();
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
