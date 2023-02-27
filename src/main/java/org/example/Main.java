package org.example;

import org.example.fileOperations.ReadTasks;
import org.example.gui.TasksListForm;
import org.example.tasks.AllTasksList;

public class Main {
    public static void main(String[] args) {

        //wczytanie zapisanych zadan z pliku:
        Thread rt = new Thread(new ReadTasks("files\\tasks.ser", AllTasksList.getInstance()));
        rt.start();
        try {
            rt.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //TasksListForm tasksListForm = new TasksListForm();
        new TasksListForm();
    }
}