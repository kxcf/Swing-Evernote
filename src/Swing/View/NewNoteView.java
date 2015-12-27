package Swing.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Swing.Control.SaveNote;
import Swing.Model.Note;

/**
 * Created by qiuxin on 15/12/26.
 */
public class NewNoteView extends JDialog {
	private JButton cancelButton;
	private JButton saveButton;
	private JButton resetButton;
	private JTextArea textContent;
	private JPanel contentPane;

	private int userId;
	private Note note;

	public NewNoteView(int userId) {
		this.userId = userId;

		setContentPane(contentPane);
		pack();
		setModal(true);

		getRootPane().setDefaultButton(saveButton);
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSave();
			}
		});

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
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

	}

	public Note getNote() {
		return note;
	}

	private void onReset() {
		textContent.setText("");
	}

	private void onSave() {
		String content = textContent.getText();
		SaveNote.save(content, userId);

		note = new Note();
		note.setTitle(content.substring(0, Math.max(10, content.length())));
		note.setContent(content);

		dispose();
	}

	private void onCancel() {
		dispose();
	}
}
