package org.example.gui;

import org.example.tasks.Task;

public class EditTaskForm extends TaskForm{

    Task task;
    String title;

    public EditTaskForm(Task task){
        super();
        doButton.addActionListener(e -> checkEditedTask());

        this.task = task;
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

    private void checkEditedTask() {

    }
}
