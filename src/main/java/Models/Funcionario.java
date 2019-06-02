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
   private String matricula;
   private String nome;
   private String email;
   private String senha;
   private int idFilial;
   private int idCargo;
   private int idStatus;
   
    public Funcionario(String fMatricula, String fNome, String fEmail, String fSenha, int fIdFilial, int fIdCargo){
        this.matricula = fMatricula;
        this.nome = fNome;
        this.email = fEmail;
        this.senha = fSenha;
        this.idFilial = fIdFilial;
        this.idCargo = fIdCargo;
    }

    public Funcionario(int id, String matricula, String nome, String email, String senha, int idFilial, int idCargo) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idFilial = idFilial;
        this.idCargo = idCargo;
    }
    
    
    
    public Funcionario() {
        
    }

    public int getId() {
        return id;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int id_cargo) {
        this.idCargo = id_cargo;
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

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int id_status) {
        this.idStatus = id_status;
    }
   
   
   
}
