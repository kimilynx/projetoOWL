package model;

public class Aluno {

    private int id;
    private String nomeAluno;
    private String matriculaAluno;
    private String curso;
    private String Turma;

    public Aluno() {
    }

    public Aluno(int id, String nomeAluno, String matriculaAluno, String curso, String turma) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.matriculaAluno = matriculaAluno;
        this.curso = curso;
    }

    public String getTurma() {
        return Turma;
    }

    public void setTurma(String Turma) {
        this.Turma = Turma;
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

}
