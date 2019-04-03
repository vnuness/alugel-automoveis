package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FGO064
 */
public class Funcionario {
   private int id;
   private String usuario;
   private String senha;
   private int matricula;
   private int id_filial;
   private int id_cargo;
   private String nome; 
   private String email;
   private int id_status; //1 - ATIVO 2 - INATIVO
   
    public Funcionario(int fId, String fUsuario, String fSenha, int fMatricula, int fId_filial, int fId_cargo, String fNome, String fEmail, int fId_status){
        this.id = fId;
        this.usuario = fUsuario;
        this.senha = fSenha;
        this.matricula = fMatricula;
        this.id_filial = fId_filial;
        this.id_cargo = fId_cargo;
        this.nome = fNome;
        this.email = fEmail;
        this.id_status= fId_status;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
   
   
   
}
