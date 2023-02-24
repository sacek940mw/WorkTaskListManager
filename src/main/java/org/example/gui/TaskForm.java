package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

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



}
