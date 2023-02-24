package org.example.gui;

import javax.swing.*;

public abstract class TaskForm {
    protected JTextField titleField;
    protected JSpinner timeSpinner;
    protected JTextArea descriptionArea;
    protected JPanel taskPanel;
    protected JButton anulujButton;
    protected JButton doButton;
    protected JLabel wTitleLabel;


    //Tworzenie nowego zadania:
    protected TaskForm() {
        TasksWindow.getInstance().getFrame().setContentPane(taskPanel);

        anulujButton.addActionListener(e-> returnToTasksListForm());
    }

    protected void returnToTasksListForm() {
        new TasksListForm();
        TasksWindow.getInstance().refresh();
    }

    protected void createUIComponents() {
        timeSpinner = new JSpinner();
        timeSpinner.setValue(15);

        anulujButton = new JButton();
        doButton = new JButton();
    }

    protected boolean checkTask() {
        //sprawdzenie czy wartości są poprawne
        if(titleField.getText().equals("")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    "Nazwa zadania nie może być pusta.",
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);

            return true;
        }
        if((int) timeSpinner.getValue() <= 0){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    "Czas wykonania zadania nie może być mniejszy lub równy 0 minut.",
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);
            return true;
        }
        //Jeśli warunki są spełnione
        return false;

    }


}
