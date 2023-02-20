package org.example;

import org.example.fileOperations.ReadTasks;
import org.example.gui.TasksListForm;

public class Main {
    public static void main(String[] args) {

        //wczytanie zapisanych zadan z pliku:
        Thread rt = new Thread(new ReadTasks());
        rt.start();
        try {
            System.out.println("A");
            rt.join();
            System.out.println("B");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //TasksListForm tasksListForm = new TasksListForm();
        new TasksListForm();
    }
}