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
    int idCliente;
    int idAvaliacao;
    int idTipoDevolutiva;
    int idLocacao;
    String dataDevolucao;
    String observacao;
    int idFilial;
    
    public Devolutiva(int dId_cliente, int dId_avaliacao, int dId_tipo_devolutiva, int dId_locacao , String dObservacao, int dIdFilial){
        this.idCliente = dId_cliente;
        this.idAvaliacao = dId_avaliacao;
        this.idTipoDevolutiva = dId_tipo_devolutiva;
        this.idLocacao = dId_locacao;
        this.observacao = dObservacao;
        this.idFilial = dIdFilial;
              
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id_cliente) {
        this.idCliente = id_cliente;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int id_avaliacao) {
        this.idAvaliacao = id_avaliacao;
    }

    public int getIdTipoDevolutiva() {
        return idTipoDevolutiva;
    }

    public void setIdTipoDevolutiva(int id_tipo_devolutiva) {
        this.idTipoDevolutiva = id_tipo_devolutiva;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
