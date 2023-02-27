package org.example.tasks;

public class DayTasksList extends TasksList{
    static DayTasksList instance = new DayTasksList();

    private DayTasksList(){
        super();
    }

    public static TasksList getInstance() {
        return instance;
    }
}
