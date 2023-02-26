package org.example.tasks;

public class AllTasksList extends TasksList{
    static AllTasksList instance = new AllTasksList();

    private AllTasksList(){
        super();
    }

    public static TasksList getInstance() {
        return instance;
    }
}
