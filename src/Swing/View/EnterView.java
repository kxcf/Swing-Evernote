package Swing.View;

import java.awt.event.*;

import javax.swing.*;

import Swing.Control.Login;

/**
 * Created by qiuxin on 15/12/24.
 */
public class EnterView extends JDialog {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	private JButton exitButton;
	private JPanel contentPane;

	private int id;

	public EnterView() {
		setContentPane(contentPane);
		pack();
		setModal(true);

		getRootPane().setDefaultButton(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onLogin();
			}
		});

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onExit();
			}
		});
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onExit();
			}
		});

		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onRegister();
			}
		});
	}

	public static void main(String[] args) {
		EnterView enterView = new EnterView();
		enterView.setVisible(true);
		System.out.println(enterView.getId());
	}

	private void onLogin() {
		int id = Login.LoginCheck(usernameField.getText(), new String(passwordField.getPassword()));
		if (id != 0) {
			this.id = id;
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, " Wrong password or username!\tPlease input again! ", "Wrong",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void onRegister() {
		RegisterView registerView = new RegisterView();
		registerView.setVisible(true);
		if (registerView.getUsername() != null) {
			usernameField.setText(registerView.getUsername());
		}
	}

	private void onExit() {
		System.exit(0);
	}

	public int getId() {
		return id;
	}
}
