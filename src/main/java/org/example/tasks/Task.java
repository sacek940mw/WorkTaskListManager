package org.example.tasks;

import java.io.Serializable;

public class Task implements Serializable, Comparable<Task> {

    private String title, description;
    int time; //time in minutes

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    void updateTask(String description, int time){
        this.description = description;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
