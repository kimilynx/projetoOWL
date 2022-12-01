package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/registro?useTimezone=true&serverTimezone";
    private static final String USER = "root";
    private static final String PASS = "boneka28";
    
    public static Connection conectaBD(){
        Connection conn = null;
        
        try {
            Class.forName(DRIVER);
            DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null,"ConexaoDAO" + erro.getMessage());
        } 
        return conn;
    }
    
}