package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenu extends JFrame{
    
    private ImageIcon img;
    private ImageIcon logo;
    private JPanel panel = new JPanel();
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JFrame frame;
    private URL caminhoImagem;
    private Image iconeTitulo;
    private JLabel lblnopanel;
    private JLabel lbltext;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.PLAIN, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    private JButton btnCadastro;
    private JButton btnLogin;
    
    TelaMenu(){
        
        setLayout(null);
        
        frame = new JFrame();
        
        btnCadastro = new JButton("CADASTRAR");
        btnCadastro.setBounds(270,350,300,50);
        btnCadastro.setBackground(new Color(28, 53, 60));
        btnCadastro.setForeground(Color.WHITE);
        btnCadastro.setFont(f3);
        btnCadastro.setBorderPainted(false); 
        btnCadastro.setContentAreaFilled(true); 
        btnCadastro.setFocusPainted(false);
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastro cadastro = new TelaCadastro();
                cadastro.setVisible(true);
                dispose();
                
            }
        });
        
        
        add(btnCadastro);
        
        btnLogin = new JButton("LOGAR");
        btnLogin.setBounds(270,420,300,50);
        btnLogin.setBackground(new Color(28, 53, 60));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(f3);
        btnLogin.setBorderPainted(false); 
        btnLogin.setContentAreaFilled(true); 
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
                dispose();
                
            }
        });
        add(btnLogin);
        
        JLabel lbltext = new JLabel("BEM-VINDO AO OWL ORACLE!");
        lbltext.setBounds(65,30,1000,90);
        lbltext.setForeground(Color.WHITE);
        lbltext.setFont(f);
        add(lbltext);
        
        JLabel lblnopanel = new JLabel("Cadastre um usuário para acessar o sistema");
        lblnopanel.setForeground(Color.BLACK);
        lblnopanel.setBounds(223,200,1000,230);
        lblnopanel.setFont(f4);
        add(lblnopanel);
        
        JLabel lbltext2 = new JLabel("Access control");
        lbltext2.setForeground(Color.WHITE);
        lbltext2.setBounds(905,360,1000,230);
        lbltext2.setFont(f2);
        add(lbltext2);
        
        panel.setBackground(Color.WHITE);
        panel.setBounds(195,150,300,400);
        panel.setSize(450,450);
        panel.setLayout(new FlowLayout());
        
        logo = new ImageIcon(this.getClass().getResource("logosemfundo300.png"));
        lbllogo = new JLabel(logo);
        lbllogo.setSize(800,800);
        lbllogo.setBounds(520,5,825,630);
        lbllogo.setLocation(600,5);
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
        new TelaMenu().setExtendedState(MAXIMIZED_BOTH);;
        
    }
}

