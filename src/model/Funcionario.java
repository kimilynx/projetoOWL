package model;

public class Funcionario {
    
    private int id;
    private String nomeFunc;
    private String emailFunc;
    private String cpfFun;

    public Funcionario() {
    }

    public Funcionario(int id, String nomeFunc, String emailFunc, String cpfFun) {
        this.id = id;
        this.nomeFunc = nomeFunc;
        this.emailFunc = emailFunc;
        this.cpfFun = cpfFun;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getEmailFunc() {
        return emailFunc;
    }

    public void setEmailFunc(String emailFunc) {
        this.emailFunc = emailFunc;
    }

    public String getCpfFun() {
        return cpfFun;
    }

    public void setCpfFun(String cpfFun) {
        this.cpfFun = cpfFun;
    }
    
    
    
}
