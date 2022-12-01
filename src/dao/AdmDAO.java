package dao;

import model.Adm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class AdmDAO {

    Connection conn;

    public AdmDAO() {
        conn = ConexaoDAO.conectaBD();
    }

    public Connection getConn() {
        return conn;
    }

    public void cadastrarAdm(Adm objAdministradorDTO) {

        String sql = "insert into Administrador (nome, email, senha) values (?, ?, ?)";

        PreparedStatement pstm = null;

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

}
