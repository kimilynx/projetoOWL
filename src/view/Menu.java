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

public class Menu extends JFrame implements ActionListener{
    
    private ImageIcon img;
    private ImageIcon logo;
    private JPanel panel = new JPanel();
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JFrame frame;
    private JLabel lbltext;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.BOLD, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    private JButton btnCadastroAluno, btnCadastroFuncionario;
    
    Menu(){
        setLayout(null);
        
        frame = new JFrame();
        btnCadastroAluno = new JButton("CADASTRAR ALUNO");
        btnCadastroFuncionario = new JButton("CADASTRAR FUNCIONÁRIO");
        
        
        logo = new ImageIcon(this.getClass().getResource("logosemfundo300.png"));
        lbllogo = new JLabel(logo);
        lbllogo.setSize(800,800);
        lbllogo.setBounds(520,5,810,400);
        lbllogo.setLocation(300,0);
        add(lbllogo);
        
        frame.setResizable(false);
        
        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        lblfundo.setSize(1366,768);
        frame.setResizable(false);
        
        btnCadastroAluno.setFont(f3);
        btnCadastroAluno.setBounds(350,520,300,50);
        btnCadastroAluno.setBorderPainted(false); 
        btnCadastroAluno.setContentAreaFilled(true); 
        btnCadastroAluno.setFocusPainted(false);
        btnCadastroAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClasseAluno aluno   = new ClasseAluno();
                aluno.setVisible(true);
                
                
            }
        });
        
        btnCadastroFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClasseFuncionario funcionario = new ClasseFuncionario();
                funcionario.setVisible(true);
                
                
                
            }
        });
        
        add(btnCadastroAluno);
        
        btnCadastroFuncionario.setFont(f3);
        btnCadastroFuncionario.setBounds(750,520,300,50);
        btnCadastroFuncionario.setBorderPainted(false); 
        btnCadastroFuncionario.setContentAreaFilled(true); 
        btnCadastroFuncionario.setFocusPainted(false);
        
        add(btnCadastroFuncionario);
        
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
        new Menu().setExtendedState(MAXIMIZED_BOTH);
        
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}

    