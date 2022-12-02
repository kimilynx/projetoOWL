package view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClasseFuncionario extends JFrame {
    
    private ImageIcon img;
    private ImageIcon logo;
    private ImageIcon btnImage;
    private JPanel panel;
    private JPanel pn1;
    private JPanel pn2;
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JButton btnEnter;
    private JFrame frame;
    private JTextField txtCod;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.BOLD, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    private JTextField txtCPF, txtNome, txtEmail;
    private JLabel lbltexto, lbltexto2, lbltexto3, lbltexto4;
    private JButton btnCadastrar;
    private JLabel lbltitulo;
    private JTable table;
    private DefaultTableModel model;
    private JPanel fundo;
    
    private String[] colunas = {"CPF", "Nome", "Email"};
    private String[][] linhas;
    
    ClasseFuncionario() {
        setLayout(null);
        
        pn1 = new JPanel();
        pn2 = new JPanel();
        lblfundo = new JLabel();
        fundo = new JPanel();
        
        fundo.setBounds(0, 0, 1000, 600);
        fundo.setBackground(new Color(18, 37, 44));
        
        panel = new JPanel();
        panel.setBounds(5, 5, 975, 80);
        panel.setBackground(new Color(40, 77, 86));
        add(panel);
        
        lbltitulo = new JLabel("CADASTRO DE FUNCIONÁRIOS");
        lbltitulo.setForeground(Color.white);
        lbltitulo.setBounds(90,20,120,50);
        lbltitulo.setFont(f);
        panel.add(lbltitulo, BorderLayout.CENTER);
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(225, 300, 125, 30);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setContentAreaFilled(true);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setFont(f4);
        pn1.add(btnCadastrar);
        
        lbltexto = new JLabel("Nome:");
        lbltexto2 = new JLabel("CPF:");
        lbltexto3 = new JLabel("Email:");
        
        lbltexto2.setBounds(20, 25, 260, 30);
        lbltexto2.setForeground(Color.white);
        lbltexto2.setFont(f4);
        pn1.add(lbltexto2);
        
        lbltexto.setBounds(20, 95, 260, 30);
        lbltexto.setForeground(Color.white);
        lbltexto.setFont(f4);
        pn1.add(lbltexto);
        
        lbltexto3.setBounds(20, 165, 260, 30);
        lbltexto3.setForeground(Color.white);
        lbltexto3.setFont(f4);
        pn1.add(lbltexto3);
        
        txtCPF = new JTextField();
        txtCPF.setFont(f4);
        txtCPF.setBounds(160, 25, 260, 30);
        pn1.add(txtCPF);
        
        txtNome = new JTextField();
        txtNome.setFont(f4);
        txtNome.setBounds(160, 95, 260, 30);
        pn1.add(txtNome);
        
        txtEmail = new JTextField();
        txtEmail.setFont(f4);
        txtEmail.setBounds(160, 165, 260, 30);
        pn1.add(txtEmail);
        
        pn1.setBounds(5, 135, 435, 350);
        pn1.setBackground(new Color(40, 77, 86));
        pn1.setLayout(null);
        add(pn1);
        
        pn2.setBounds(450, 135, 530, 350);
        pn2.setBackground(Color.black);
        pn2.setLayout(null);
        add(pn2);
        
        model = new DefaultTableModel(linhas, colunas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(model);
        JScrollPane panelTabela = new JScrollPane(table);
        panelTabela.setBounds(0, 0, pn2.getWidth(), pn2.getHeight());
        
        pn2.add(panelTabela);
        
        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        //lblfundo.setSize(1366,768);

        setTitle("Menu");
        setSize(1000, 600);
        setBackground(new Color(33, 71, 82));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        lblfundo.setSize(1000, 600);
        
        add(panel);
        add(fundo);
        
    }
    
    public static void main(String[] args) {
        new ClasseFuncionario();
        
    }
}
