package Swing.View;

import Swing.Control.Login;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by qiuxin on 15/12/24.
 */
public class EnterView {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;
    private JButton exitButton;
    private JPanel main;

    public EnterView(final JFrame frame) {
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                RegisterView.main(null);
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Login.LoginCheck(usernameField.getText(), new String(passwordField.getPassword()));
                if (0 != id){
                    frame.dispose();
                    MainView.main(id);
                }else{
                    JOptionPane.showMessageDialog(null, " Wrong password or username!\tPlease input again! ",
                            "Wrong", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Evernote");
        frame.setContentPane(new EnterView(frame).main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
