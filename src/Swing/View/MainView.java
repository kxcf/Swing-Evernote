package Swing.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import Swing.Model.Note;

/**
 * Created by qiuxin on 15/12/24.
 */
public class MainView extends JFrame {
	private JButton newNoteButton;
	private JTextField searchTextField;
	private JPanel contentPane;
	private JButton searchButton;
	private JButton exitButton;
	private JList noteList;

	private int userId;

	public MainView(int userId) {
		this.userId = userId;

		setContentPane(contentPane);

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onExit();
			}
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onExit();
			}
		});

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSearch();
			}
		});

		noteList.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				return super.getListCellRendererComponent(list, ((Note) value).getContent(), index, isSelected,
						cellHasFocus);
			}
		});

		noteList.setModel(new DefaultListModel<Note>());

		newNoteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onNewNote();
			}
		});

	}

	public static void main(String args[]) {
		JFrame frame = new MainView(234535);
		frame.setMinimumSize(new Dimension(640, 480));
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	private void onNewNote() {
		NewNoteView newNoteView = new NewNoteView(userId);
		newNoteView.setVisible(true);
		if (newNoteView.getNote() != null) {
			DefaultListModel<Note> listModel = (DefaultListModel<Note>) noteList.getModel();
			listModel.addElement(newNoteView.getNote());
		}
	}

	private void onExit() {
		System.exit(0);
	}

	private void onSearch() {
		searchTextField.setText("");
	}

}
