package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.AllTasksList;
import org.example.tasks.Task;

import javax.swing.*;

public class AddTaskForm extends TaskForm{

    String filePath;

    public AddTaskForm(String filePath){
        super();
        this.filePath = filePath;
        doButton.addActionListener(e -> createTask());

        anulujButton.addActionListener(e -> returnToTasksListForm());

        fillWindowWithData();
    }

    protected void returnToTasksListForm() {
        new TasksListForm();
        TasksWindow.getInstance().refresh();
    }

    protected void fillWindowWithData() {
        doButton.setText("Dodaj zadanie");
    }

    protected void createTask(){
        if(checkTask())
            return;

        Task task = new Task(titleField.getText(), (Integer) timeSpinner.getValue());
        task.setDescription(descriptionArea.getText());
        String result = AllTasksList.getInstance().addTask(task);
        if(result.startsWith("Dodano zadanie")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    result,
                    "Zadanie nie zostało dodane",
                    JOptionPane.PLAIN_MESSAGE);

            SaveTasks st = new SaveTasks(filePath, AllTasksList.getInstance());
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
