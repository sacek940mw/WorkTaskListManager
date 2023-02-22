package org.example.tasks;

import java.io.Serializable;

public class Task implements Serializable, Comparable<Task> {

    private String title, description;
    int time; //time in minutes

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    void updateTask(){
        this.description = description;
        this.time = time;
    }

    void updateTask(Task task){
        this.description = task.description;
        this.time = task.time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    @Override
    public int compareTo(Task o) {
        return this.title.compareTo(o.title);
    }
}
