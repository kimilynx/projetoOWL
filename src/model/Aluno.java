package model;

public class Aluno {

    private int id;
    private String nomeAluno;
    private String matriculaAluno;
    private String curso;
    private String turma;

    public Aluno() {
    }

    public Aluno(String matriculaAluno, String nomeAluno, String curso, String turma) {
        this.nomeAluno = nomeAluno;
        this.matriculaAluno = matriculaAluno;
        this.curso = curso;
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
