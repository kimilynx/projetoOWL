package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;

public class AlunoDAO {

    Connection conn;

    public AlunoDAO() {
        conn = ConexaoDAO.conectaBD();
    }

    public Connection getConn() {
        return conn;
    }

    public void cadastrarAluno(Aluno alunoObjeto) throws SQLException {

        String sql = "insert into Aluno (nome, matricula, curso) values (?, ?, ?)";

        PreparedStatement pstm;

        try {

            pstm = getConn().prepareStatement(sql);
            pstm.setString(1, alunoObjeto.getNomeAluno());
            pstm.setString(2, alunoObjeto.getMatriculaAluno());
            pstm.setString(3, alunoObjeto.getCurso());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o aluno no Banco de Dados" + erro);
        } finally {
            conn.close();

        }
    }

    public List<Aluno> listAdm() throws SQLException {
        String sql = "SELECT * FROM Aluno";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Aluno> alunos = new ArrayList<>();

        try {
            stmt = getConn().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setNomeAluno(rs.getString("nome"));
                aluno.setMatriculaAluno(rs.getString("matricula"));
                aluno.setCurso(rs.getString("curso"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error na hora de listar os Alunos", "ERROR", JOptionPane.WARNING_MESSAGE);
        } finally {
            conn.close();
        }
        return alunos;
    }

}
