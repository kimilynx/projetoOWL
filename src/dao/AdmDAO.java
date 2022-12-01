package dao;

import model.Adm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdmDAO {

    Connection conn;

    public AdmDAO() {
        conn = ConexaoDAO.conectaBD();
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrarAdm(Adm objAdministradorDTO) throws SQLException {

        String sql = "insert into Administrador (nome, email, senha) values (?, ?, ?)";

        PreparedStatement pstm;

        try {

            pstm = getConn().prepareStatement(sql);
            pstm.setString(1, objAdministradorDTO.getNome_adm());
            pstm.setString(2, objAdministradorDTO.getEmail_adm());
            pstm.setString(3, objAdministradorDTO.getSenha_adm());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "AdmDAO" + erro);
            erro.printStackTrace();
        }
    }

    public List<Adm> listAdm() throws SQLException {
        String sql = "SELECT * FROM Administrador";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Adm> adms = new ArrayList<>();

        try {
            stmt = getConn().prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Adm adm = new Adm();
                adm.setNome_adm(rs.getString("nome"));
                adm.setSenha_adm(rs.getString("senha"));
                adm.setEmail_adm(rs.getString("email"));
                adms.add(adm);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error na hora de listar os Administradores", "ERROR", JOptionPane.WARNING_MESSAGE);
        } 
        return adms;
    }

}
