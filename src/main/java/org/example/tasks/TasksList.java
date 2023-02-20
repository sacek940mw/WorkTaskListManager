package org.example.tasks;

import java.util.ArrayList;

public enum TasksList {

    INSTANCE();

    private final ArrayList<Task> tasks;

    private TasksList() {
        this.tasks = new ArrayList<>();
    }

    public synchronized String addTask(Task task) {
        boolean contains = tasks.stream().anyMatch(t -> t.getTitle().equals(task.getTitle()));
        if(contains){
            return "Takie zadanie jest już dodane";
        }
        tasks.add(task);
        return "Dodano zadanie: " + task.getTitle();
    }

    public synchronized void removeTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public static TasksList getInstance() {
        return INSTANCE;
    }
}
