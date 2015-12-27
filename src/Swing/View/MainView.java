package Swing.View;

import Swing.Model.Note;
import Swing.Control.getNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by qiuxin on 15/12/24.
 */
public class MainView {
    private static int userId;
    private JButton newNoteButton;
    private JTextField searchTextField;
    private JPanel Main;
    private JButton searchButton;
    private JButton exitButton;
    private JPanel notePanel;
    private JList list1;


    public MainView(final JFrame frame) {
        searchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                searchTextField.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

//        newNoteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Note note = new Note();
////                note.setTitle("New note");
//                note.setContent("I write a new text");
//                DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
//                listModel.addElement(note);
//            }
//        });
//
        list1.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {
                return super.getListCellRendererComponent(list, ((Note)value).getContent(), index, isSelected, cellHasFocus);
            }
        });

        list1.setModel(new DefaultListModel<Note>());

        newNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewNoteView.newNote(userId,frame);
//                show();
            }
        });

    }

    public void show(){
        Note note = new Note();
        note.setContent(getNote.get(userId));
        DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
        listModel.addElement(note);
    }


    public static void main(int id) {
        JFrame frame = new JFrame("Notes");
        frame.setContentPane(new MainView(frame).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLocationRelativeTo(null);
        setUserId(id);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getNotePanel() {
        return notePanel;
    }

    public static void setUserId(int id) {
        userId = id;
    }

}