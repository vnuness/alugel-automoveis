/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.Date;

/**
 *
 * @author FGO064
 */
public class Devolutiva {
    int id;
    int id_cliente;
    int id_avaliacao;
    int id_tipo_devolutiva;
    int id_status_locacao;
    Date data_devolucao;
    String observacao;
    
    public Devolutiva(int dId, int dId_cliente, int dId_avaliacao, int dId_tipo_devolutiva,
            int dId_status_locacao, Date dData_devolucao, String dObservacao){
        this.id = dId;
        this.id_cliente = dId_cliente;
        this.id_avaliacao = dId_avaliacao;
        this.id_tipo_devolutiva = dId_tipo_devolutiva;
        this.id_status_locacao = dId_status_locacao;
        this.data_devolucao = dData_devolucao;
        this.observacao = dObservacao;
              
    }

    public Devolutiva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public int getId_tipo_devolutiva() {
        return id_tipo_devolutiva;
    }

    public void setId_tipo_devolutiva(int id_tipo_devolutiva) {
        this.id_tipo_devolutiva = id_tipo_devolutiva;
    }

    public int getId_status_locacao() {
        return id_status_locacao;
    }

    public void setId_status_locacao(int id_status_locacao) {
        this.id_status_locacao = id_status_locacao;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
