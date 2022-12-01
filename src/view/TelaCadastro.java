package view;

import dao.AdmDAO;
import model.Adm;
import view.TelaMenu;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame implements ActionListener{
    
    public String senha;
    
    private JLabel lblfundo2, lbllogo2, lblcadastro, lblnome, lblemail, lblsenha;
    private ImageIcon img,logo;
    private JPanel panel = new JPanel();
    private JTextField txtNome, txtEmail;
    private JPasswordField txtSenha;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.PLAIN, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 35);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 25);
    private Font f5 = new Font("Century Gothic", Font.BOLD, 20);
    private JButton btnCadastrar;
    private AdmDAO dao;

    public TelaCadastro(){
        setLayout(null);
        JFrame frame = new JFrame();
        
        dao = new AdmDAO();
        
        btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBounds(290,520,250,50);
        btnCadastrar.setFont(f5);
        btnCadastrar.setBackground(new Color(28, 53, 60));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBorderPainted(false); 
        btnCadastrar.setContentAreaFilled(true); 
        btnCadastrar.setFocusPainted(false);
        
        add(btnCadastrar);
        
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome, email, senha;
                nome = txtNome.getText();
                email = txtEmail.getText();
                senha = txtSenha.getText();
                
                Adm adm = new Adm();
                
                adm.setNome_adm(nome);
                adm.setEmail_adm(email);
                adm.setSenha_adm(senha);
                
                dao.cadastrarAdm(adm);
            }
        });
        
        lblcadastro = new JLabel("CADASTRO");
        lblcadastro.setBounds(325,170,400,50);
        lblcadastro.setForeground(Color.BLACK);
        lblcadastro.setFont(f3);
        add(lblcadastro);
        
        lblnome = new JLabel("Nome:");
        lblnome.setBounds(248,205,100,100);
        lblnome.setForeground(Color.BLACK);
        lblnome.setFont(f4);
        add(lblnome);
        
        lblemail = new JLabel("Email:");
        lblemail.setBounds(248,290,100,100);
        lblemail.setForeground(Color.BLACK);
        lblemail.setFont(f4);
        add(lblemail);
        
        lblsenha = new JLabel("Senha:");
        lblsenha.setBounds(248,375,100,100);
        lblsenha.setForeground(Color.BLACK);
        lblsenha.setFont(f4);
        add(lblsenha);
        
        txtNome = new JTextField();
        txtNome.setBounds(250,275,335,30);
        add(txtNome);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(250,360,335,30);
        add(txtEmail);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(250,445,335,30);
        
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
        
        setTitle("Cadastro");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        add(panel);
        add(lblfundo2);;
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
        TelaMenu menu = new TelaMenu();
        menu.setVisible(true);
        dispose();
        
        
        txtNome.getText();
        
    }
    public static void main(String[] args) {
        new TelaCadastro().setExtendedState(MAXIMIZED_BOTH);
    }

}