package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

import javax.swing.*;

public class EditTaskForm extends TaskForm{

    Task task;
    String title;

    public EditTaskForm(Task task){
        super();
        doButton.addActionListener(e -> updateTask());
        this.task = new Task(task);
        this.title = task.getTitle();
        fillWindowWithData();
    }

    private void fillWindowWithData(){
        titleField.setText(task.getTitle());
        timeSpinner.setValue(task.getTime());
        descriptionArea.setText(task.getDescription());
        wTitleLabel.setText("EDYTUJ ZADANIE");
        doButton.setText("Edytuj zadanie");
    }

    private void updateTask() {
        if(checkTask())
            return;

        task.setTitle(titleField.getText());
        task.setDescription(descriptionArea.getText());
        task.setTime((Integer) timeSpinner.getValue());

        String result = TasksList.getInstance().updateTask(title, task);
        System.out.println(result);
        if(result.startsWith("Zaktualizowano zadanie")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    result,
                    "Zadanie nie zostało zaktualizowane",
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
