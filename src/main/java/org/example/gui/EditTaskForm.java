package org.example.gui;

import org.example.fileOperations.SaveTasks;
import org.example.tasks.AllTasksList;
import org.example.tasks.Task;

import javax.swing.*;

public class EditTaskForm extends TaskForm{

    Task task;
    String title;

    public EditTaskForm(Task task){
        super();
        this.task = new Task(task);
        this.title = task.getTitle();

        doButton.addActionListener(e -> updateTask());
        anulujButton.addActionListener(e -> returnToTasksListForm());

        fillWindowWithData();
    }

    private void fillWindowWithData(){
        titleField.setText(task.getTitle());
        timeSpinner.setValue(task.getTime());
        descriptionArea.setText(task.getDescription());
        wTitleLabel.setText("EDYTUJ ZADANIE");
        doButton.setText("Edytuj");
    }

    protected void returnToTasksListForm() {
        new TasksListForm();
        TasksWindow.getInstance().refresh();
    }

    private void updateTask() {
        if(checkTask())
            return;

        task.setTitle(titleField.getText());
        task.setDescription(descriptionArea.getText());
        task.setTime((Integer) timeSpinner.getValue());

        String result = AllTasksList.getInstance().updateTask(title, task);
        System.out.println(result);
        if(result.startsWith("Zaktualizowano zadanie")){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    result,
                    "Zadanie nie zostało zaktualizowane",
                    JOptionPane.PLAIN_MESSAGE);

            SaveTasks st = new SaveTasks("files\\tasks.ser", AllTasksList.getInstance());
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
