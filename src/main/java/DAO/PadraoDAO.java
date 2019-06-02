/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.ParseException;

/**
 *
 * @author oem
 */
public interface PadraoDAO {
    public boolean salvar (Object x) throws ParseException;
    public boolean atualizar(Object x);
}
