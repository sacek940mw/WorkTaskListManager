package org.example.tasks;

import java.io.Serializable;
import java.util.ArrayList;

public class TasksList implements Serializable {
    private ArrayList<Task> tasks;

    private static TasksList instance = new TasksList();

    private TasksList() {
        this.tasks = new ArrayList<>();
    }

    public String addTask(Task task){
        boolean contains = tasks.stream().anyMatch(t -> t.getTitle() == task.getTitle());
        if(contains == true){
            return "Takie zadanie jest już dodane";
        }
        tasks.add(task);
        return "Dodano zadanie: " + task.getTitle();
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public static TasksList getInstance() {
        return instance;
    }

    protected Object readResolve(){
        return getInstance();
    }
}
