package Swing.View;

import static Swing.Control.Register.submitCheck;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

/**
 * Created by qiuxin on 15/12/24.
 */
public class RegisterView extends JDialog {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleRadioButton;
	private JButton resetButton;
	private JButton submitButton;
	private JButton exitButton;
	private JPanel contentPane;

	private String username;

	public RegisterView() {
		setContentPane(contentPane);
		pack();
		setModal(true);

		getRootPane().setDefaultButton(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSubmit();
            }
        });

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});

		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onReset();
			}
		});
	}

	public static void main(String[] args) {
		RegisterView registerView = new RegisterView();
		registerView.setVisible(true);
		System.out.println(registerView.getUsername());
	}

	private void onReset() {
		usernameField.setText("");
		passwordField.setText("");
		nameField.setText("");
		maleRadioButton.setSelected(true);
	}

	private void onSubmit() {
		switch (submitCheck(usernameField.getText(), new String(passwordField.getPassword()), nameField.getText(),
				maleRadioButton.isSelected(), femaleRadioButton.isSelected())) {
			case 0:
				JOptionPane.showMessageDialog(null, " Username has been used!\tPlease change again! ",
						"Username has been used", JOptionPane.ERROR_MESSAGE);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,
						" Username invalid!\t"
								+ "Usernames must have only letters,numbers, underscores\tPlease change again! ",
						"Username Envalid", JOptionPane.WARNING_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Please enter everything\tPlease change again! ", "Something Empty",
						JOptionPane.WARNING_MESSAGE);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Password must contains 6 to 16 characters\tPlease change again! ",
						"Password Length Error", JOptionPane.WARNING_MESSAGE);
				break;
			case 1:
				Swing.Control.Register.submit(usernameField.getText(), new String(passwordField.getPassword()),
						nameField.getText(), maleRadioButton.isSelected(), femaleRadioButton.isSelected());
				username = usernameField.getText();
                dispose();
				break;
		}
	}

	private void onCancel() {
		dispose();
	}

	public String getUsername() {
		return username;
	}
}
