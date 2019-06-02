/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author oem
 */
public abstract class Clientea {

    protected int id;
    protected String nome;
    protected String cnh;
    protected int idCategoriaCnh;
    protected String validadeCnh;
    protected String email;
    protected String endereco;
    protected String cep;
    protected String bairro;
    protected String complemento;
    protected int numero;
    protected String cidade;
    protected String estado;
    protected String celular;
    protected int status;
    protected int idCategoriaCliente;

    public int getIdCategoriaCliente() {
        return idCategoriaCliente;
    }

    public void setIdCategoriaCliente(int idCategoriaCliente) {
        this.idCategoriaCliente = idCategoriaCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdCategoriaCnh() {
        return idCategoriaCnh;
    }

    public void setIdCategoriaCnh(int idCategoriaCnh) {
        this.idCategoriaCnh = idCategoriaCnh;
    }

    public String getValidadeCnh() {
        return validadeCnh;
    }

    public void setValidadeCnh(String validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double aplicaDesconto(double valor, int qtdDias) {
        double desconto;
        double valorAtualizado;
        if (qtdDias >= 7) {
            desconto = (valor * 10) / 100;
            valorAtualizado = valor - desconto;
        } else {
            valorAtualizado = valor;
        }

        return valorAtualizado;
    }
}
