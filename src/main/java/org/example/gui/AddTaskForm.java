package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTaskForm {
    private JTextField titleField;
    private JSpinner timeSpinner;
    private JTextArea descriptionArea;
    private JPanel taskPanel;
    private JButton anulujButton;
    private JButton dodajButton;

    public AddTaskForm() {
        JDialog frame = new JDialog();
        frame.setDefaultCloseOperation(closeWindow());
        frame.setSize(800,600);
        frame.setContentPane(taskPanel);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        titleField = new JTextField();
        titleField.setVisible(true);
        descriptionArea = new JTextArea();
        descriptionArea.setVisible(true);
        timeSpinner = new JSpinner();
        timeSpinner.setValue(15);

        anulujButton = new JButton();
        dodajButton = new JButton();

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    int closeWindow(){
        return JFrame.DISPOSE_ON_CLOSE;
    }
}
