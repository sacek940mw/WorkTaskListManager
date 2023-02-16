package org.example.tasks;

import java.io.Serializable;
import java.util.ArrayList;

public class TasksList implements Serializable {
    private ArrayList<Task> tasks;

    public TasksList() {
    }

    String addTask(Task task){
        boolean contains = tasks.stream().anyMatch(t -> t.getTitle() == task.getTitle());
        if(contains == true){
            return "Takie zadanie jest już dodane";
        }
        tasks.add(task);
        return "Dodano zadanie: " + task.getTitle();
    }

    void removeTask(Task task){
        tasks.remove(task);
    }

}
