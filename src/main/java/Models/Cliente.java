package Models;

import java.util.Date;

/**
 *
 * @author RaphaelOrlandi
 */
public class Cliente {

    private int id;
    private String nome;
    private String cpf_cnpj;
    private int id_sexo;
    private String cnh;
    private int id_categoria_cnh;
    private String rg;
    private String email;
    private String nacionalidade;
    private Date data_nascimento;
    private String endereco;
    private String cep;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String celular;

    public Cliente() {

    }
    final String DATA_NASCIMENTO = "teste";

    public Cliente(int cId, String cNome, String cCpf_Cnpj, int cId_sexo, String cCnh, int cId_categoria_cnh,
            String cRg, String cEmail, String cNacionalidade, Date cData_nascimento, String cEndereco,
            String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular) {
        this.id = cId;
        this.nome = cNome;
        this.cpf_cnpj = cCpf_Cnpj;
        this.id_sexo = cId_sexo;
        this.cnh = cCnh;
        this.id_categoria_cnh = cId_categoria_cnh;
        this.rg = cRg;
        this.email = cEmail;
        this.nacionalidade = cNacionalidade;
        this.data_nascimento = cData_nascimento;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;
    }

    public Cliente(String cNome, String cCpf_Cnpj, int cId_sexo, String cCnh, int cId_categoria_cnh,
            String cRg, String cEmail, String cNacionalidade, Date cData_nascimento, String cEndereco,
            String cCep, String cBairro, String cComplemento, String cCidade, String cEstado, String cCelular) {
        this.nome = cNome;
        this.cpf_cnpj = cCpf_Cnpj;
        this.id_sexo = cId_sexo;
        this.cnh = cCnh;
        this.id_categoria_cnh = cId_categoria_cnh;
        this.rg = cRg;
        this.email = cEmail;
        this.nacionalidade = cNacionalidade;
        this.data_nascimento = cData_nascimento;
        this.endereco = cEndereco;
        this.cep = cCep;
        this.bairro = cBairro;
        this.complemento = cComplemento;
        this.cidade = cCidade;
        this.estado = cEstado;
        this.celular = cCelular;

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

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public int getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(int id_sexo) {
        this.id_sexo = id_sexo;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getId_categoria_cnh() {
        return id_categoria_cnh;
    }

    public void setId_categoria_cnh(int id_categoria_cnh) {
        this.id_categoria_cnh = id_categoria_cnh;
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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
