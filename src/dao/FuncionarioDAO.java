/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import model.Funcionario;

/**
 *
 * @author Migas
 */
public class FuncionarioDAO {

    Connection conn;

    public FuncionarioDAO() {
        conn = ConexaoDAO.conectaBD();
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrarFuncionario(Funcionario funcObjeto) throws SQLException {

        String sql = "insert into Funcionario (nome, cpf, email) values (?, ?, ?)";

        PreparedStatement pstm;

        try {

            pstm = getConn().prepareStatement(sql);
            pstm.setString(1, funcObjeto.getNomeFunc());
            pstm.setString(2, funcObjeto.getCpfFun());
            pstm.setString(3, funcObjeto.getEmailFunc());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o Funcionario no Banco de Dados" + erro);
        } finally {
            conn.close();

        }
    }

    public List<Funcionario> listFunc() throws SQLException {
        String sql = "SELECT * FROM Funcionario";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = getConn().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNomeFunc(rs.getString("nome"));
                funcionario.setCpfFun(rs.getString("cpf"));
                funcionario.setEmailFunc(rs.getString("email"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error na hora de listar os Funcionarios", "ERROR", JOptionPane.WARNING_MESSAGE);
        } finally {
            conn.close();
        }
        return funcionarios;
    }

    public boolean deleFunc(Funcionario funcionario) throws SQLException {

        String sql = "DELETE FROM Funcionario where nome = (?) and cpf= (?)";

        PreparedStatement stmt = null;

        try {
            stmt = getConn().prepareStatement(sql);

            stmt.setString(1, funcionario.getNomeFunc());
            stmt.setString(2, funcionario.getCpfFun());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionario" + ex, "Banco de dados", JOptionPane.WARNING_MESSAGE);

            return false;
        } finally {
            closeConn();
        }

    }

    public boolean updateFunc(Funcionario antigo, Funcionario novo) {
        String sql = "UPDATE Funcionario SET nome= (?), cpf = (?), email = (?) where email = (?)";

        PreparedStatement stmt = null;

        try {
            stmt = getConn().prepareCall(sql);

            stmt.setString(1, novo.getNomeFunc());
            stmt.setString(2, novo.getCpfFun());
            stmt.setString(3, novo.getEmailFunc());

            stmt.setString(4, antigo.getEmailFunc());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração de Funcionario\n" + ex, "Error", 0);
            return false;
        } finally {

            closeConn();

        }

    }

}
