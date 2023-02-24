package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

import javax.swing.*;

public class AddTaskForm extends TaskForm{

    public AddTaskForm(){
        super();
        doButton.addActionListener(e -> createTask());
        fillWindowWithData();
    }

    private void fillWindowWithData() {
        doButton.setText("Dodaj zadanie");
    }

    private void createTask(){
        if(checkTask())
            return;

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
