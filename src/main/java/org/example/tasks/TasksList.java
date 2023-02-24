package org.example.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

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

    public synchronized void updateTask(Task task){
        for(Task t : tasks){
            if(t.getTitle().equals(task.getTitle())){
                t.updateTask(task);
                break;
            }
        }
    }

    public synchronized Optional<Task> getTaskByTitle(String title){
        return tasks.stream().parallel().filter(t -> t.getTitle().equals(title)).findFirst();
    }

    public synchronized void removeTask(String title){
        Task task = null;
        for(Task t : TasksList.getInstance().tasks){
            if(t.getTitle().equals(title))
                task = t;
        }
        if(task != null){
            removeTask(task);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public static TasksList getInstance() {
        return instance;
    }
}
