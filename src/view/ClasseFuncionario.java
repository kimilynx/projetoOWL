package view;

import dao.FuncionarioDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

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
    private Funcionario funcionario;
    private FuncionarioDAO dao;
    private static ClasseFuncionario classeFuncionario;
    
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
        lbltitulo.setBounds(90, 20, 120, 50);
        lbltitulo.setFont(f);
        panel.add(lbltitulo, BorderLayout.CENTER);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(225, 300, 125, 30);
        btnCadastrar.setContentAreaFilled(true);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setFont(f4);
        btnCadastrar.setBackground(new Color(40, 77, 86));
        btnCadastrar.setForeground(Color.white);
        btnCadastrar.setBorder(new LineBorder(Color.BLACK.darker(), 1, true));
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpfFun(txtCPF.getText().trim());
                funcionario.setNomeFunc(txtNome.getText().trim());
                funcionario.setEmailFunc(txtEmail.getText().trim());

                dao = new FuncionarioDAO();
                try {
                    dao.cadastrarFuncionario(funcionario);

                    pn2.revalidate();
                    pn2.repaint();
                    dispose();
                    new ClasseFuncionario().setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO" + ex, "Banco de dados", JOptionPane.WARNING_MESSAGE);

                }
            }
        });
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
        table.addMouseListener(new EventoMouse());
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
        listar();
    }

    private void listar() {
        dao = new FuncionarioDAO();

        try {

            for (Funcionario o : dao.listFunc()) {
                model.addRow(new Object[]{o.getCpfFun(), o.getNomeFunc(), o.getEmailFunc()});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO" + ex, "Banco de dados", JOptionPane.WARNING_MESSAGE);

        }
    }

    private class EventoMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getClickCount() == 2 && !e.isConsumed()) {
                e.consume();

                funcionario = new Funcionario();

                int linha = table.getSelectedRow();

                funcionario.setCpfFun(model.getValueAt(linha, 0).toString());
                funcionario.setNomeFunc(model.getValueAt(linha, 1).toString());
                funcionario.setEmailFunc(model.getValueAt(linha, 2).toString());

                new TelaVisualizar().setVisible(true);
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            table.setSelectionBackground(Color.gray.brighter());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            table.setSelectionBackground(Color.white);

        }

    }

    private class TelaVisualizar extends JFrame {

        private JPanel painel;
        private JButton leave, btnDelete, btnAlterar;
        private JTextField txtCpf, txtNome, txtEmail;
        private JLabel lblCpf, lblNome, lblEmail, lblTitulo;

        public TelaVisualizar() {
            configFrame();

            leave = new JButton("X");
            leave.setBackground(new Color(223, 63, 16));
            leave.setBounds(painel.getWidth() - 55, 0, 55, 20);
            leave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            painel.add(leave);

            txtCpf = new JTextField(funcionario.getCpfFun());
            txtCpf.setBounds(40, 75, 300, 30);
            painel.add(txtCpf);

            txtNome = new JTextField(funcionario.getNomeFunc());
            txtNome.setBounds(40, 145, 300, 30);
            painel.add(txtNome);

            txtEmail = new JTextField(funcionario.getEmailFunc());
            txtEmail.setBounds(40, 215, 300, 30);
            painel.add(txtEmail);

            txtCpf.setFont(new Font("Arial", 0, 15));
            txtEmail.setFont(new Font("Arial", 0, 15));
            txtNome.setFont(new Font("Arial", 0, 15));

            lblTitulo = new JLabel("Informações do Funcionário");
            lblTitulo.setFont(new Font("Arial", 1, 20));
            lblTitulo.setBounds(40, 5, 300, 30);
            painel.add(lblTitulo);

            lblCpf = new JLabel("CPF");
            lblCpf.setFont(new Font("Arial", 1, 15));
            lblCpf.setBounds(40, 50, 120, 30);
            painel.add(lblCpf);

            lblNome = new JLabel("Nome");
            lblNome.setFont(new Font("Arial", 1, 15));
            lblNome.setBounds(40, 120, 150, 30);
            painel.add(lblNome);

            lblEmail = new JLabel("Email");
            lblEmail.setFont(new Font("Arial", 1, 15));
            lblEmail.setBounds(40, 190, 120, 30);
            painel.add(lblEmail);

            lblTitulo.setForeground(Color.white);
            lblEmail.setForeground(Color.white);
            lblNome.setForeground(Color.white);
            lblCpf.setForeground(Color.white);

            btnDelete = new JButton("Deletar");
            btnDelete.setBackground(painel.getBackground());
            btnDelete.setBounds(380, 289, 100, 25);
            btnDelete.addActionListener(new EventoDeletar(funcionario));
            painel.add(btnDelete);

            btnAlterar = new JButton("Alterar");
            btnAlterar.setBackground(painel.getBackground());
            btnAlterar.setBounds(380, 260, 100, 25);
            btnAlterar.addActionListener(new EventoAlterar(funcionario));
            painel.add(btnAlterar);

            painel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            painel.setBackground(new Color(18, 37, 44));
        }

        private class EventoDeletar implements ActionListener {

            Funcionario func;

            public EventoDeletar(Funcionario func) {
                this.func = func;
                dao = new FuncionarioDAO();
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                int i = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Objetivo", JOptionPane.WARNING_MESSAGE);
                if (i == 0) {
                    try {
                        if (dao.deleFunc(func)) {

                            JOptionPane.showMessageDialog(null, "Objetivo deletado com sucesso", "Objetivos", JOptionPane.INFORMATION_MESSAGE);
                            pn2.repaint();
                            pn2.revalidate();
                            classeFuncionario.dispose();
                            new ClasseFuncionario().setVisible(true);
                            dispose();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "ERRO" + ex, "Banco de dados", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }

        }

        private class EventoAlterar implements ActionListener {

            Funcionario antigo;

            public EventoAlterar(Funcionario antigo) {
                this.antigo = antigo;
                dao = new FuncionarioDAO();
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                Funcionario novo = new Funcionario(txtNome.getText(), txtEmail.getText(), txtCpf.getText());

                if (dao.updateFunc(antigo, novo)) {
                    JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso\n", "Objetivos", JOptionPane.INFORMATION_MESSAGE);
                }

                pn2.repaint();
                pn2.revalidate();
                classeFuncionario.dispose();
                new ClasseFuncionario().setVisible(true);
                dispose();

            }

        }

        private void configFrame() {
            setSize(500, 350);
            setLocationRelativeTo(null);
            setUndecorated(true);
            setLayout(null);

            painel = new JPanel(null);
            painel.setBackground(new Color(207, 227, 225));
            painel.setSize(this.getSize());
            add(painel);
        }
    }

    public static void main(String[] args) {
        classeFuncionario = new ClasseFuncionario();

    }

}
