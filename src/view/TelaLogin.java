package view;

import view.TelaMenu;
import com.sun.xml.internal.org.jvnet.fastinfoset.RestrictedAlphabet;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener{
    
    public String senha;
    
    private JLabel lblfundo2, lbllogo2, lbllogin, lblnome, lblemail, lblsenha;
    private ImageIcon img,logo;
    private JPanel panel = new JPanel();
    private JTextField txtNome, txtEmail;
    private JPasswordField txtSenha;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.PLAIN, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 35);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 25);
    private Font f5 = new Font("Century Gothic", Font.BOLD, 20);
    private JButton btnLogar;

    public TelaLogin(){
        setLayout(null);
        JFrame frame = new JFrame();
        
        btnLogar = new JButton("LOGAR");
        btnLogar.setBounds(290,520,250,50);
        btnLogar.setFont(f5);
        btnLogar.setBackground(new Color(28, 53, 60));
        btnLogar.setForeground(Color.WHITE);
        btnLogar.setBorderPainted(false); 
        btnLogar.setContentAreaFilled(true); 
        btnLogar.setFocusPainted(false);
        btnLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin login = new TelaLogin();
                login.setVisible(true);
                dispose();
                
            }
        });
        add(btnLogar);
        
        lbllogin = new JLabel("LOGIN");
        lbllogin.setBounds(365,170,400,50);
        lbllogin.setForeground(Color.BLACK);
        lbllogin.setFont(f3);
        add(lbllogin);
        
        lblnome = new JLabel("Nome:");
        lblnome.setBounds(248,240,100,100);
        lblnome.setForeground(Color.BLACK);
        lblnome.setFont(f4);
        add(lblnome);
        
        lblsenha = new JLabel("Senha:");
        lblsenha.setBounds(248,325,100,100);
        lblsenha.setForeground(Color.BLACK);
        lblsenha.setFont(f4);
        add(lblsenha);
        
        txtNome = new JTextField();
        txtNome.setBounds(250,310,335,30);
        add(txtNome);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(250,395,335,30);
        add(txtSenha);
        
        JLabel lbltext = new JLabel("BEM-VINDO AO OWL ORACLE!");
        lbltext.setBounds(65,30,1000,90);
        lbltext.setForeground(Color.WHITE);
        lbltext.setFont(f);
        add(lbltext);
        
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
        lbllogo2 = new JLabel(logo);
        lbllogo2.setSize(800,800);
        lbllogo2.setBounds(520,5,825,630);
        lbllogo2.setLocation(600,5);
        add(lbllogo2);
        
        frame.setResizable(false);

        ImageIcon img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo2 = new JLabel(img);
        lblfundo2.setSize(1366,768);
        frame.setResizable(false);
        
        setTitle("Login");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        add(panel);
        add(lblfundo2);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        TelaMenu menu = new TelaMenu();
        menu.setVisible(true);
        dispose();
        
        
        
    }
    public static void main(String[] args) {
        new TelaLogin().setExtendedState(MAXIMIZED_BOTH);;
    }
    
}

