package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClasseFuncionario extends JFrame{
    
    private ImageIcon img;
    private ImageIcon logo;
    private ImageIcon btnImage;
    private JPanel panel = new JPanel();
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JButton btnEnter;
    private JFrame frame;
    private JLabel lbltext;
    private JTextField txtCod;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.BOLD, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    
    ClasseFuncionario(){
        setLayout(null);
        
        frame = new JFrame(); 
        
        frame.setResizable(false);
        
        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        lblfundo.setSize(1366,768);
        frame.setResizable(false);
        
        DefaultTableModel model = new DefaultTableModel
        
        add(panel);
        add(lblfundo);
        
    }
    
    public static void main(String[] args) {
        new ClasseFuncionario().setExtendedState(MAXIMIZED_BOTH);
        
    }
}

    