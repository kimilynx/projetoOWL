package view;

import dao.AlunoDAO;
import dao.FuncionarioDAO;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import model.Aluno;
import model.Funcionario;

public class InsiraCodigo extends JFrame {

    private ImageIcon img;
    private ImageIcon logo;
    private ImageIcon btnImage;
    private JPanel panel = new JPanel();
    private JLabel lbllogo;
    private JLabel lblfundo;
    private JButton btnEnter;
    private JFrame frame;
    private JLabel lbltext;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.BOLD, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 18);
    private JTextField jtextfield;
    private JLabel lbl1;
    private AlunoDAO aDao = new AlunoDAO();
    private FuncionarioDAO fDao = new FuncionarioDAO();

    InsiraCodigo() {
        setLayout(null);

        frame = new JFrame();
        lbl1 = new JLabel("Insira seu código cadastrado");
        lbl1.setBounds(500, 370, 500, 50);
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(f2);
        add(lbl1);

        jtextfield = new JTextField();
        jtextfield.setFont(f3);

        jtextfield.setBounds(300, 470, 620, 50);
        add(jtextfield);

        logo = new ImageIcon(this.getClass().getResource("logosemfundo300.png"));
        lbllogo = new JLabel(logo);
        lbllogo.setSize(800, 800);
        lbllogo.setBounds(300, 50, 825, 300);
        add(lbllogo);

        frame.setResizable(false);

        img = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo = new JLabel(img);
        lblfundo.setSize(1366, 768);

        btnEnter = new JButton("Enter");

        btnEnter.setBounds(930, 470, 200, 50);
        btnEnter.setBorderPainted(false);
        btnEnter.setContentAreaFilled(true);
        btnEnter.setFocusPainted(false);
        btnEnter.setFont(f3);
        btnEnter.setBorder(null);
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Boolean isFalse = false;
                Boolean isFalse2 = false;
                String mat = jtextfield.getText();
                String cpf = jtextfield.getText();

                try {
                    for (Aluno a : aDao.listAluno()) {

                        if (mat.equals(a.getMatriculaAluno())) { // True

                            isFalse = true;

                            break;
                        }
                    }

                    for (Funcionario f : fDao.listFunc()) {
                        if (cpf.equals(f.getCpfFun())) { // True

                            isFalse2 = true;

                            break;
                        }
                    }

                    if (isFalse || isFalse2) {
                        JOptionPane.showMessageDialog(null, "Acesso Liberado!", "Catraca!", JOptionPane.INFORMATION_MESSAGE);
                        repaint();
                        revalidate();
                        dispose();
                        new InsiraCodigo().setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Acesso Negado!", "Catraca!", JOptionPane.WARNING_MESSAGE);
                        repaint();
                        revalidate();
                        dispose();
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro no BD " + ex, "Banco de Dados!", JOptionPane.WARNING_MESSAGE);

                }

            }
        });

        add(btnEnter);

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
