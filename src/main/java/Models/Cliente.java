package Models;

import java.util.Date;

/**
 *
 * @author RaphaelOrlandi
 */
public class Cliente {

    private int id;
    private String nome;
    private String cpfCnpj;
    private int idsexo;
    private String cnh;
    private int idCategoriaCnh;
    private String rg;
    private String validadeCnh;
    private String email;
    private String nacionalidade;
    private String dataNascimento;
    private String endereco;
    private String cep;
    private String bairro;
    private String complemento;
    private int numero;
    private String cidade;
    private String estado;
    private String celular;
    private int status;
    private int idCategoriaCliente;

    public Cliente() {

    }

    public Cliente(int cId, String cNome, String cCpfCnpj, int cIdsexo, String cCnh, int cIdcategoriacnh,
            String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cEndereco,
            String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cStatus,
            int cIdCategoriaCliente) {
        this.id = cId;
        this.nome = cNome;
        this.cpfCnpj = cCpfCnpj;
        this.idsexo = cIdsexo;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdcategoriacnh;
        this.rg = cRg;
        this.email = cEmail;
        this.nacionalidade = cNacionalidade;
        this.dataNascimento = cDatanascimento;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;
        this.status = cStatus;
        this.idCategoriaCliente = cIdCategoriaCliente;
    }

    public Cliente(String cNome, String cCpfCnpj, int cIdsexo, int cIdCategoriaCliente, String cCnh, int cIdcategoriacnh,
            String cRg, String cEmail, String cNacionalidade, String cDatanascimento, String cValidadeCnh, String cCep, String cEndereco, int cNumero,
            String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular
            ) {
        this.nome = cNome;
        this.cpfCnpj = cCpfCnpj;
        this.idsexo = cIdsexo;
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
    
    public Cliente(String cNome, String cCpfCnpj, String cCnh, int cIdCategoriaCnh, String cEmail, String cDataNascimento, String cEndereco, String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular, int cIdCategoriaCliente)
    {
        this.nome = cNome;
        this.cpfCnpj = cCpfCnpj;
        this.cnh = cCnh;
        this.idCategoriaCnh = cIdCategoriaCnh;
        this.email = cEmail;
        this.dataNascimento = cDataNascimento;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;
        this.idCategoriaCliente = cIdCategoriaCliente;
        
    }
    
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdCategoriaCliente() {
        return idCategoriaCliente;
    }

    public void setIdCategoriaCliente(int idCategoriaCliente) {
        this.idCategoriaCliente = idCategoriaCliente;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(int idSexo) {
        this.idsexo = idSexo;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdcategoriacnh() {
        return idCategoriaCnh;
    }

    public void setIdcategoriacnh(int idcategoriacnh) {
        this.idCategoriaCnh = idcategoriacnh;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
