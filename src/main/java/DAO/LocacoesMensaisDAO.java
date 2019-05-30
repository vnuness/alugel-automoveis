/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.LocacoesMensais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oem
 */
public class LocacoesMensaisDAO {

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

    public static ArrayList<LocacoesMensais> getLocacoes(int idFilial) {
        ArrayList<LocacoesMensais> avaliacao = new ArrayList<LocacoesMensais>();
        String query;
        if (idFilial != 4) {
            query = "SELECT \n"
                    + "        DAYOFMONTH(`locacoes`.`data_locacao`) AS `data_locacao`,\n"
                    + "        COUNT(0) AS `quantidade`\n"
                    + "    FROM\n"
                    + "        ((`locacoes`\n"
                    + "        JOIN `cliente` ON ((`cliente`.`id` = `locacoes`.`id_cliente`)))\n"
                    + "        JOIN `categoria_cliente` ON ((`categoria_cliente`.`id` = `cliente`.`id_categoria_cliente`)))\n"
                    + "    WHERE\n"
                    + "        (`locacoes`.`data_locacao` BETWEEN DATE_FORMAT(NOW(), '%Y-%m-01') AND NOW())\n"
                    + "        AND `locacoes`.`id_filial` = " + idFilial + "\n"
                    + "    GROUP BY DAYOFMONTH(`locacoes`.`data_locacao`)";
        } else {
            query = "SELECT \n"
                    + "        DAYOFMONTH(`locacoes`.`data_locacao`) AS `data_locacao`,\n"
                    + "        COUNT(0) AS `quantidade`\n"
                    + "    FROM\n"
                    + "        ((`locacoes`\n"
                    + "        JOIN `cliente` ON ((`cliente`.`id` = `locacoes`.`id_cliente`)))\n"
                    + "        JOIN `categoria_cliente` ON ((`categoria_cliente`.`id` = `cliente`.`id_categoria_cliente`)))\n"
                    + "    WHERE\n"
                    + "        (`locacoes`.`data_locacao` BETWEEN DATE_FORMAT(NOW(), '%Y-%m-01') AND NOW())\n"
                    + "    GROUP BY DAYOFMONTH(`locacoes`.`data_locacao`)";
        }

        try (Connection conn = obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                LocacoesMensais lista = new LocacoesMensais();
                lista.setDataLocacao(rs.getInt("data_locacao"));
                lista.setQuantidade(rs.getInt("quantidade"));
                avaliacao.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return avaliacao;
    }
}
