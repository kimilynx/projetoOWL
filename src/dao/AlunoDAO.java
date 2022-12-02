package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aluno;

public class AlunoDAO {

    Connection conn;

    public AlunoDAO() {
        conn = ConexaoDAO.conectaBD();
    }

    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void cadastrarAluno(Aluno alunoObjeto) throws SQLException {

        String sql = "insert into Aluno (matricula, nome, curso ,turma) values (?, ?, ?, ?)";

        PreparedStatement pstm;

        try {

            pstm = getConn().prepareStatement(sql);
            pstm.setString(1, alunoObjeto.getMatriculaAluno());
            pstm.setString(2, alunoObjeto.getNomeAluno());
            pstm.setString(3, alunoObjeto.getCurso());
            pstm.setString(4, alunoObjeto.getTurma());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o aluno no Banco de Dados" + erro);
        } finally {
            conn.close();

        }
    }

    public List<Aluno> listAluno() throws SQLException {
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
                aluno.setTurma(rs.getString("turma"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error na hora de listar os Alunos", "ERROR", JOptionPane.WARNING_MESSAGE);
        } finally {
            conn.close();
        }
        return alunos;
    }

    public boolean deleteAluno(Aluno aluno) throws SQLException {

        String sql = "DELETE FROM Aluno where nome = (?) and matricula= (?)";

        PreparedStatement stmt = null;

        try {
            stmt = getConn().prepareStatement(sql);

            stmt.setString(1, aluno.getNomeAluno());
            stmt.setString(2, aluno.getMatriculaAluno());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
            return false;
        } finally {
            closeConn();
        }

    }

    public boolean updateAluno(Aluno alunoAntigo, Aluno novo) {
        String sql = "UPDATE Aluno SET nome= (?), turma = (?), curso = (?) where matricula = (?)";

        PreparedStatement stmt = null;

        try {
            stmt = getConn().prepareCall(sql);

            stmt.setString(1, novo.getNomeAluno());
            stmt.setString(2, novo.getTurma());
            stmt.setString(3, novo.getCurso());

            stmt.setString(4, alunoAntigo.getMatriculaAluno());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração de Aluno\n" + ex, "Error", 0);
            return false;
        } finally {

            closeConn();

        }

    }

}
