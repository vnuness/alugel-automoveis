/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author vsilva
 */
public class Veiculo 
{
    private int id;
    private String modelo;
    private String montadora;
    private int ano;
    private String placa;
    private String renavam;
    private int idCombustivel;
    private int idCambio;
    private int idStatus;
    private double valor;
    private String acessorio;
    
    public Veiculo() 
    {
        
    }
    
    public Veiculo(int vId, String vModelo) {
        this.id = vId;
        this.modelo = vModelo;
    }
    
    public Veiculo(int vId, String vModelo, String vMontadora, int vAno, String vPlaca, String vRenavam, double valor, int vIdCombustivel, int vIdCambio, int vIdStatus, String vAcessorio)
    {
        this.id = vId;
        this.modelo = vModelo;
        this.montadora = vMontadora;
        this.ano = vAno;
        this.valor = valor;
        this.placa = vPlaca;
        this.renavam = vRenavam;
        this.idCombustivel = vIdCombustivel;
        this.idCambio = vIdCambio;
        this.idStatus = vIdStatus;
        this.acessorio = vAcessorio;
    }
    
    public Veiculo(String vModelo, String vMontadora, int vAno, String vPlaca, String vRenavam, double valor, int vIdCombustivel, int vIdCambio, int vIdStatus, String vAcessorio)
    {
        this.modelo = vModelo;
        this.montadora = vMontadora;
        this.ano = vAno;
        this.placa = vPlaca;
        this.valor = valor;
        this.renavam = vRenavam;
        this.idCombustivel = vIdCombustivel;
        this.idCambio = vIdCambio;
        this.idStatus = vIdStatus;
        this.acessorio = vAcessorio;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(int idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public int getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(int idCambio) {
        this.idCambio = idCambio;
    }
    
    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(String acessorio) {
        this.acessorio = acessorio;
    }
    
    
}
