/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author FGO064
 */
public class Locacao {
    private int id;
    private int idCliente;
    private int idVeiculo;
    private double valor;
    private String dataLocacao;
    private String obs;
    private int idStatusLocacao; //nao achei referencia para o nome, se puder avisar no grupo qual é o correto  
    
    public Locacao(int lIdCliente,int lIdVeiculo, double lValor, String lObs)
    {
        this.idCliente = lIdCliente;
        this.idVeiculo = lIdVeiculo;
        this.valor = lValor;
        this.obs = lObs;
    }
    
    public Locacao() {
        
    }
    
    public double aplicaDesconto(double valor, int idCategoria, int qtdDias) {
        double desconto = 0;
        double valorAtualizado = 0;
        if(idCategoria == 3) {
            if(qtdDias > 1) {
                desconto = (valor * 15) / 100;
                valorAtualizado = valor - desconto;
            } else {
                desconto = (valor * 10) / 100;
                valorAtualizado = valor - desconto;
            }
        } else if(idCategoria == 1) {
            if(qtdDias >= 7) {
                desconto = (valor * 10) / 100;
                valorAtualizado = valor - desconto;
            } else {
                valorAtualizado = valor;
            }
        }
        
        return valorAtualizado;
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

    public void setIdcliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public int getIdStatusLocacao() {
        return idStatusLocacao;
    }

    public void setIdStatusLocacao(int idStatusLocacao) {
        this.id = idStatusLocacao;
    }
    
}