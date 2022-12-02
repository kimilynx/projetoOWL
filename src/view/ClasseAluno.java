package view;

import dao.AlunoDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import model.Aluno;

public class ClasseAluno extends JFrame {

    private ImageIcon img;
    private ImageIcon logo;
    private ImageIcon btnImage;
    private JPanel panel,panel2;
    private JPanel pn1;
    private JPanel pn2;
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JButton btnEnter;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.BOLD, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    private JTextField txtNome, txtMatricula, txtCurso, txtTurma;
    private JLabel lbltexto, lbltexto2, lbltexto3, lbltexto4;
    private JButton btnCadastrar;
    private JLabel lbltitulo;
    private JTable table;
    private DefaultTableModel model;
    private JPanel fundo;
    private AlunoDAO dao;
    private Aluno aluno;
    private TelaVisualizar telaVisualizar;
    private static ClasseAluno classeAluno;

    private String[] colunas = {"Código de matricula", "Nome", "Curso", "Turma"};
    private String[][] linhas;

    ClasseAluno() {
        setLayout(null);

        pn1 = new JPanel();
        pn2 = new JPanel();
        lblfundo = new JLabel();
        fundo = new JPanel();
        
        fundo.setBounds(0, 0, 1000, 600);
        fundo.setBackground(new Color(18, 37, 44));

        panel = new JPanel();
        panel.setBounds(5, 5, 975, 80);
        panel.setBackground(new Color(33, 71, 82));
        add(panel);
        
        panel2 = new JPanel();
        panel2.setBounds(5, 540, 975, 60);
        panel2.setBackground(new Color(33, 71, 82));
        add(panel2);

        lbltitulo = new JLabel("CADASTRO DE ALUNOS");
        lbltitulo.setForeground(Color.white);
        lbltitulo.setBounds(20,20,120,50);
        lbltitulo.setFont(f);
        panel.add(lbltitulo, BorderLayout.CENTER);

        lbltexto = new JLabel("Matrícula:");
        lbltexto2 = new JLabel("Nome:");
        lbltexto3 = new JLabel("Curso:");
        lbltexto4 = new JLabel("Turma:");

        lbltexto.setBounds(20, 25, 260, 30);
        lbltexto.setForeground(Color.white);
        lbltexto.setFont(f4);
        pn1.add(lbltexto);

        lbltexto2.setBounds(20, 95, 260, 30);
        lbltexto2.setForeground(Color.white);
        lbltexto2.setFont(f4);
        pn1.add(lbltexto2);
        
        lbltexto3.setBounds(20, 165, 260, 30);
        lbltexto3.setForeground(Color.white);
        lbltexto3.setFont(f4);
        pn1.add(lbltexto3);

        lbltexto4.setBounds(20, 235, 260, 30);
        lbltexto4.setForeground(Color.white);
        lbltexto4.setFont(f4);
        pn1.add(lbltexto4);

        txtNome = new JTextField();
        txtNome.setFont(f4);
        txtNome.setBounds(160, 95, 260, 30);
        pn1.add(txtNome);

        txtMatricula = new JTextField();
        txtMatricula.setFont(f4);
        txtMatricula.setBounds(160, 25, 260, 30);
        pn1.add(txtMatricula);

        txtCurso = new JTextField();
        txtCurso.setFont(f4);
        txtCurso.setBounds(160, 165, 260, 30);
        pn1.add(txtCurso);

        txtTurma = new JTextField();
        txtTurma.setFont(f4);
        txtTurma.setBounds(160, 235, 260, 30);
        pn1.add(txtTurma);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(225, 300, 125, 30);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setContentAreaFilled(true);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setFont(f4);
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = new Aluno();
                aluno.setMatriculaAluno(txtMatricula.getText().trim());
                aluno.setNomeAluno(txtNome.getText().trim());
                aluno.setTurma(txtTurma.getText().trim());
                aluno.setCurso(txtCurso.getText().trim());

                dao = new AlunoDAO();

                try {
                    dao.cadastrarAluno(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado!");

                    pn2.repaint();
                    pn2.revalidate();

                    dispose();
                    new ClasseAluno();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO" + ex, "Banco de dados", JOptionPane.WARNING_MESSAGE);

                }

            }
        });

        pn1.add(btnCadastrar);

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        lblfundo.setSize(1000, 600);

        add(panel);
        add(fundo);

        listar();
    }

    private void listar() {
        dao = new AlunoDAO();

        try {

            for (Aluno o : dao.listAluno()) {
                model.addRow(new Object[]{o.getMatriculaAluno(), o.getNomeAluno(), o.getCurso(), o.getTurma()});
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
                
                aluno = new Aluno();

                int linha = table.getSelectedRow();

                aluno.setMatriculaAluno(model.getValueAt(linha, 0).toString());
                aluno.setNomeAluno(model.getValueAt(linha, 1).toString());
                aluno.setCurso(model.getValueAt(linha, 2).toString());
                aluno.setTurma(model.getValueAt(linha, 3).toString());

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
        private JTextField txtNome, txtMat, txtCurso, txtTurma;
        private JLabel lblNome, lblMat, lblTurma, lblCurso, lblTitulo;

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

            txtNome = new JTextField(aluno.getNomeAluno());
            txtNome.setBounds(40, 75, 300, 30);
            painel.add(txtNome);

            txtMat = new JTextField(aluno.getMatriculaAluno());
            txtMat.setBounds(40, 145, 300, 30);
            txtMat.setEditable(false);
            painel.add(txtMat);

            txtCurso = new JTextField(aluno.getCurso());
            txtCurso.setBounds(40, 215, 300, 30);
            painel.add(txtCurso);

            txtTurma = new JTextField(aluno.getTurma());
            txtTurma.setBounds(40, 285, 300, 30);
            painel.add(txtTurma);

            txtNome.setFont(new Font("Arial", 0, 15));
            txtCurso.setFont(new Font("Arial", 0, 15));
            txtMat.setFont(new Font("Arial", 0, 15));

            lblTitulo = new JLabel("Informações do Aluno");
            lblTitulo.setFont(new Font("Arial", 1, 20));
            lblTitulo.setBounds(40, 5, 250, 30);
            painel.add(lblTitulo);

            lblNome = new JLabel("Nome");
            lblNome.setFont(new Font("Arial", 1, 15));
            lblNome.setBounds(40, 50, 120, 30);
            painel.add(lblNome);

            lblMat = new JLabel("Matricula");
            lblMat.setFont(new Font("Arial", 1, 15));
            lblMat.setBounds(40, 120, 150, 30);
            painel.add(lblMat);

            lblCurso = new JLabel("Curso");
            lblCurso.setFont(new Font("Arial", 1, 15));
            lblCurso.setBounds(40, 190, 120, 30);
            painel.add(lblCurso);

            lblTurma = new JLabel("Turma");
            lblTurma.setFont(new Font("Arial", 1, 15));
            lblTurma.setBounds(40, 260, 120, 30);
            painel.add(lblTurma);

            lblTitulo.setForeground(Color.white);
            lblTurma.setForeground(Color.white);
            lblCurso.setForeground(Color.white);
            lblMat.setForeground(Color.white);
            lblNome.setForeground(Color.white);

            btnDelete = new JButton("Deletar");
            btnDelete.setBackground(painel.getBackground());
            btnDelete.setBounds(380, 289, 100, 25);
            btnDelete.addActionListener(new EventoDeletar(aluno));
            painel.add(btnDelete);

            btnAlterar = new JButton("Alterar");
            btnAlterar.setBackground(painel.getBackground());
            btnAlterar.setBounds(380, 260, 100, 25);
            btnAlterar.addActionListener(new EventoAlterar(aluno));
            painel.add(btnAlterar);

            painel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            painel.setBackground(new Color(18, 37, 44));
        }

        private class EventoDeletar implements ActionListener {

            Aluno al;

            public EventoDeletar(Aluno aluno) {
                this.al = aluno;
                dao = new AlunoDAO();
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                int i = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Objetivo", JOptionPane.WARNING_MESSAGE);
                if (i == 0) {
                    try {
                        if (dao.deleteAluno(al)) {

                            JOptionPane.showMessageDialog(null, "Objetivo deletado com sucesso", "Objetivos", JOptionPane.INFORMATION_MESSAGE);
                            pn2.repaint();
                            pn2.revalidate();
                            classeAluno.dispose();
                            new ClasseAluno().setVisible(true);
                            dispose();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ClasseAluno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }

        private class EventoAlterar implements ActionListener {

            Aluno antigoAluno;

            public EventoAlterar(Aluno antigoAluno) {
                this.antigoAluno = antigoAluno;
                dao = new AlunoDAO();
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                Aluno novoAl = new Aluno(txtMat.getText(), txtNome.getText(), txtCurso.getText(), txtTurma.getText());

                if (dao.updateAluno(antigoAluno, novoAl)) {
                    JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso\n", "Objetivos", JOptionPane.INFORMATION_MESSAGE);
                }

                pn2.repaint();
                pn2.revalidate();
                classeAluno.dispose();
                new ClasseAluno().setVisible(true);
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
        classeAluno = new ClasseAluno();

    }
}
