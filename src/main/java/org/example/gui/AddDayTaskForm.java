package org.example.gui;

import org.example.tasks.Task;

public class AddDayTaskForm extends TaskForm{

    Task task;
    String filePath;

    public AddDayTaskForm(String filePath, Task task) {
        super();
        this.task = new Task(task);
        this.filePath = filePath;

        anulujButton.addActionListener(e -> returnToDayTasksListForm());

        fillWindowWithData();
    }

    protected void returnToDayTasksListForm() {
        new DayTasksListForm();
        TasksWindow.getInstance().refresh();
    }

    protected void fillWindowWithData(){
        titleField.setText(task.getTitle());
        timeSpinner.setValue(task.getTime());
        descriptionArea.setText(task.getDescription());
        wTitleLabel.setText("DODAJ ZADANIE");
        doButton.setText("Dodaj");
    }
}
