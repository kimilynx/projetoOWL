package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
   
    private JFrame frame;
    private JPanel panel,panel2;
    private ImageIcon img,img2;
    private JLabel lblimg,lblfundo2;
    private JButton btnCadastrar;
    private Font f = new Font("Century Gothic", Font.BOLD, 50);
    private Font f2 = new Font("Century Gothic", Font.PLAIN, 30);
    private Font f3 = new Font("Century Gothic", Font.BOLD, 35);
    private Font f4 = new Font("Century Gothic", Font.BOLD, 25);
    private Font f5 = new Font("Century Gothic", Font.BOLD, 20);
    private Font f6 = new Font("Century Gothic", Font.BOLD, 15);
   
    Menu(){
        frame = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
        lblimg  = new JLabel();
       
        ImageIcon img2 = new ImageIcon(this.getClass().getResource("fundoOWL.jpg"));
        lblfundo2 = new JLabel(img);
        lblfundo2.setSize(1366,768);
        frame.setResizable(false);
       
        setTitle("Menu");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
   
    public static void main(String[] args) {
        new Menu();
    }
   
}
