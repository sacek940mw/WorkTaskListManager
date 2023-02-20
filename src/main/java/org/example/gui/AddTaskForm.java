package org.example.gui;

import org.example.tasks.Task;
import org.example.tasks.TasksList;

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

    //private final JFrame frame;

    public AddTaskForm() {
        MainWindow.getInstance().getFrame().setContentPane(taskPanel);
        /*
        frame = new JFrame();
        frame.setDefaultCloseOperation(closeWindow());
        frame.setSize(800,600);
        frame.setContentPane(taskPanel);
        frame.setVisible(true);
        */
        dodajButton.addActionListener(e -> checkNewTask());
        //anulujButton.addActionListener(e->frame.dispose());
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

    }

    private void checkNewTask() {
        //sprawdzenie czy wartości są poprawne
        if(titleField.getText().equals("")){
            System.out.println("Nazwa zadania nie może być pusta");
        }else if((int) timeSpinner.getValue() <= 0){
            System.out.println("Czas wykonania zadania nie może być mniejszy lub równy 0 minut");
        }else{
            //Jeśli warunki są spełnione dodaj nowe zadanie do listy zadań.
            createTask();
        }
    }

    void createTask(){
        Task task = new Task(titleField.getText(), (Integer) timeSpinner.getValue());
        task.setDescription(descriptionArea.getText());
        String result = TasksList.getInstance().addTask(task);
        System.out.println(result);
        if(result.startsWith("Dodano zadanie")){
            //frame.dispose();
        }
    }

    private int closeWindow(){
        return JFrame.DISPOSE_ON_CLOSE;
    }

    public AddTaskForm getInstance() {
        return this;
    }

    public JPanel getTaskPanel() {
        return taskPanel;
    }
}
