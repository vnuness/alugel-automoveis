/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.TotalLocacoesPorCategoria;
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
public class TotalLocacoesPorCategoriaDAO {

    public static ArrayList<TotalLocacoesPorCategoria> getLocacoes(int idFilial) {
        ArrayList<TotalLocacoesPorCategoria> totalLocacoes = new ArrayList<TotalLocacoesPorCategoria>();

        String query;

        if (idFilial != 4) {
            query = "SELECT \n"
                    + "        COUNT(0) AS `y`, `categoria_cliente`.`categoria` AS `name`\n"
                    + "    FROM\n"
                    + "        ((`locacoes`\n"
                    + "        JOIN `cliente` ON ((`cliente`.`id` = `locacoes`.`id_cliente`)))\n"
                    + "        JOIN `categoria_cliente` ON ((`categoria_cliente`.`id` = `cliente`.`id_categoria_cliente`)))\n"
                    + "    WHERE\n"
                    + "        (`locacoes`.`data_locacao` BETWEEN DATE_FORMAT(NOW(), '%Y-%m-01') AND NOW())\n"
                    + "        AND `locacoes`.`id_filial` = " + idFilial + "\n"
                    + "    GROUP BY `name`";
        } else {
            query = "SELECT \n"
                    + "        COUNT(0) AS `y`, `categoria_cliente`.`categoria` AS `name`\n"
                    + "    FROM\n"
                    + "        ((`locacoes`\n"
                    + "        JOIN `cliente` ON ((`cliente`.`id` = `locacoes`.`id_cliente`)))\n"
                    + "        JOIN `categoria_cliente` ON ((`categoria_cliente`.`id` = `cliente`.`id_categoria_cliente`)))\n"
                    + "    WHERE\n"
                    + "        (`locacoes`.`data_locacao` BETWEEN DATE_FORMAT(NOW(), '%Y-%m-01') AND NOW())\n"
                    + "    GROUP BY `name`";
        }

        try (Connection conn = ConnectionUtil.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TotalLocacoesPorCategoria lista = new TotalLocacoesPorCategoria();
                lista.setName(rs.getString("name"));
                lista.setY(rs.getInt("y"));
                totalLocacoes.add(lista);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }

        return totalLocacoes;
    }
}
