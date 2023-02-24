package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

import javax.swing.*;

public class AddTaskForm extends TaskForm{

    public AddTaskForm(){
        super();
        doButton.addActionListener(e -> checkNewTask());
        fillWindowWithData();
    }

    private void fillWindowWithData() {
        doButton.setText("Dodaj zadanie");
    }

    private void checkNewTask() {
        //sprawdzenie czy wartości są poprawne
        if(titleField.getText().equals("")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    "Nazwa zadania nie może być pusta.",
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);


        }else if((int) timeSpinner.getValue() <= 0){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    "Czas wykonania zadania nie może być mniejszy lub równy 0 minut.",
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);
        }else{
            //Jeśli warunki są spełnione dodaj nowe zadanie do listy zadań.
            createTask();
        }
    }

    private void createTask(){
        System.out.println("Create task method");
        Task task = new Task(titleField.getText(), (Integer) timeSpinner.getValue());
        task.setDescription(descriptionArea.getText());
        String result = TasksList.getInstance().addTask(task);
        if(result.startsWith("Dodano zadanie")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    result,
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);

            SaveTasks st = new SaveTasks();
            st.run();
            returnToTasksListForm();
        }else{
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    result,
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

}
