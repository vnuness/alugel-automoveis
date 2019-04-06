/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author vsilva
 */
public class ListaCliente {
    
    private int id;
    private String nome;
    private String cpfcnpj;
    private int idsexo;
    private String cnh;
    private int idcategoriacnh;
    private String rg;
    private String email;
    private String nacionalidade;
    private Date datanascimento;
    private String endereco;
    private String cep;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String celular;
    private String status;
    private int idCategoriaCliente;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdCategoriaCliente() {
        return idCategoriaCliente;
    }

    public void setIdCategoriaCliente(int idCategoriaCliente) {
        this.idCategoriaCliente = idCategoriaCliente;
    }
    
    public ListaCliente() {
        
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

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public int getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(int id_sexo) {
        this.idsexo = idsexo;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdcategoriacnh() {
        return idcategoriacnh;
    }

    public void setIdcategoriacnh(int idcategoriacnh) {
        this.idcategoriacnh = idcategoriacnh;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
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
    

    
}
