package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class InsiraCodigo extends JFrame{
    
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
    
    InsiraCodigo(){
        setLayout(null);
        
        frame = new JFrame(); 
        
        logo = new ImageIcon(this.getClass().getResource("logosemfundo300.png"));
        lbllogo = new JLabel(logo);
        lbllogo.setSize(800,800);
        lbllogo.setBounds(520,5,825,30);
        lbllogo.setLocation(300,0);
        add(lbllogo);
        
        frame.setResizable(false);
        
        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        lblfundo.setSize(1366,768);
        frame.setResizable(false);
        
        setTitle("Menu");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        add(panel);
        add(lbllogo);
        add(lblfundo);
        
    }
    
    public static void main(String[] args) {
        new InsiraCodigo().setExtendedState(MAXIMIZED_BOTH);
        
    }
}

    