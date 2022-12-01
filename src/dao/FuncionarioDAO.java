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

    public void cadastrarFuncionario(Funcionario funcObjeto) throws SQLException {

        String sql = "insert into Aluno (nome, cpf, email) values (?, ?, ?)";

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

    public List<Funcionario> listAdm() throws SQLException {
        String sql = "SELECT * FROM Aluno";

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
}
