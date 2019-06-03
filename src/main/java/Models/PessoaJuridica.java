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
public class PessoaJuridica extends Cliente {
    private String cnpj;
    
    
    
    public PessoaJuridica(String cNome, String cCpfCnpj, String cCnh, int cIdCategoriaCnh, String cEmail, String cValidadeCnh, String cEndereco, String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cIdCategoriaCliente, int cNumero)
    {
        this.numero = cNumero;
        this.nome = cNome;
        this.cnpj = cCpfCnpj;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdCategoriaCnh;
        this.email = cEmail;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.validadeCnh = cValidadeCnh;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;
        this.idCategoriaCliente = cIdCategoriaCliente;
        
    }
    
    public PessoaJuridica(int cId, String cNome, String cCpfCnpj, String cCnh, int cIdCategoriaCnh, String cEmail, String cValidadeCnh, String cEndereco, String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cIdCategoriaCliente, int cNumero)
    {
        this.id = cId;
        this.nome = cNome;
        this.cnpj = cCpfCnpj;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdCategoriaCnh;
        this.email = cEmail;
        this.validadeCnh = cValidadeCnh;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.numero = cNumero;
        this.estado = cEstado;
        this.celular = cCelular;
        this.idCategoriaCliente = cIdCategoriaCliente;
        
        
    }
    
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public double aplicaDesconto(double valor, int qtdDias) {
        
        return valor;
    }
    
    
}
