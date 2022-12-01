package model;

public class Adm {
    
    private int id;
    private String nome_adm, email_adm, senha_adm;
    
    
    
    public String getNome_adm() {
        return nome_adm;
        
    }
    
    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
        
    }
    
    public String getEmail_adm() {
        return email_adm;
    }
    
    public void setEmail_adm(String email_adm) {
        this.email_adm = email_adm;
    }

    public String getSenha_adm() {
        return senha_adm;
    }

    public void setSenha_adm(String senha_adm) {
        this.senha_adm = senha_adm;
    }

    public Adm() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public Adm(String nome_adm, String email_adm, String senha_adm) {
        this.nome_adm = nome_adm;
        this.email_adm = email_adm;
        this.senha_adm = senha_adm;
    }
    
    
    
}