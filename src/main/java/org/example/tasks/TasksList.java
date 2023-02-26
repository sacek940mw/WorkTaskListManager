package org.example.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public abstract class TasksList {



    private ArrayList<Task> tasks;

    protected TasksList() {
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

    public synchronized String updateTask(String oldTitle, Task task){
        boolean contains = false;
        if(!oldTitle.equals(task.getTitle())){
            System.out.println("T: " + task.getTitle());
            contains = tasks.stream().anyMatch(t -> {
                System.out.println("t: " + t.getTitle());
                return t.getTitle().equals(task.getTitle());
            });
            System.out.println(contains);
        }
        if(contains){
            return "Takie zadanie jest już dodane";
        }
        for(Task t : tasks){
            if(t.getTitle().equals(oldTitle)){
                t.updateTask(task);
                Collections.sort(tasks);
                return "Zaktualizowano zadanie: " + task.getTitle();
            }
        }
        return "Nie zaktualizowano zadania";
    }

    public synchronized Optional<Task> getTaskByTitle(String title){
        return tasks.stream().parallel().filter(t -> t.getTitle().equals(title)).findFirst();
    }

    public synchronized void removeTask(String title){
        Task task = null;
        for(Task t : tasks){
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


}
