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
public class PessoaFisica extends Cliente {
    protected String cpf;
    protected int idSexo;
    protected String rg;
    protected String nacionalidade;
    protected String dataNascimento;
    
    
    public PessoaFisica(int cId, String cNome, String cCpfCnpj, int cIdsexo, String cCnh, int cIdcategoriacnh,
            String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cEndereco,
            String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cStatus,
            int cIdCategoriaCliente, String validadeCnh, int cNumero) {
        this.id = cId;
        this.nome = cNome;
        this.cpf = cCpfCnpj;
        this.idSexo = cIdsexo;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdcategoriacnh;
        this.idCategoriaCliente = cIdCategoriaCliente;
        this.rg = cRg;
        this.email = cEmail;
        this.nacionalidade = cNacionalidade;
        this.dataNascimento = cDatanascimento;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.numero = cNumero;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;
        this.status = cStatus;
        this.validadeCnh = validadeCnh;
    }

    public PessoaFisica(String cNome, String cCpfCnpj, int cIdsexo, int cIdCategoriaCliente, String cCnh, int cIdcategoriacnh,
            String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cValidadeCnh, String cCep, String cEndereco, int cNumero,
            String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular
            ) {
        this.nome = cNome;
        this.cpf = cCpfCnpj;
        this.idSexo = cIdsexo;
        this.idCategoriaCliente = cIdCategoriaCliente;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdcategoriacnh;
        this.rg = cRg;
        this.email = cEmail;
        this.nacionalidade = cNacionalidade;
        this.dataNascimento = cDatanascimento;
        this.validadeCnh = cValidadeCnh;
        this.cep = cCep;
        this.endereco = cEndereco;
        this.numero = cNumero;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;

    }
    
    public PessoaFisica() {
        
    }
    
    public int getIdSexo() {
        return idSexo;
    }
    
    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
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

    public void setIdCategoriaCliente(int idCategoriaCliente) {
        this.idCategoriaCliente = idCategoriaCliente;
    }

    public int getIdCategoriaCliente() {
        return idCategoriaCliente;
    }
    
    
    
}
