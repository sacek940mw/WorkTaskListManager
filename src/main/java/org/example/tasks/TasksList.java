package org.example.tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TasksList {

    static TasksList instance = new TasksList();

    private ArrayList<Task> tasks;

    private TasksList() {
        this.tasks = new ArrayList<>();
    }

    public synchronized String addTask(Task task) {
        boolean contains = tasks.stream().anyMatch(t -> t.getTitle().equals(task.getTitle()));
        if(contains){
            return "Takie zadanie jest już dodane";
        }
        tasks.add(task);
        Collections.sort(tasks);
        return "Dodano zadanie: " + task.getTitle();
    }

    public synchronized void removeTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @SuppressWarnings("Unchecked")
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public static TasksList getInstance() {
        return instance;
    }
}
