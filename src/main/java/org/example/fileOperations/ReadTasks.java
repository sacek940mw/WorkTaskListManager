package org.example.fileOperations;

import org.example.gui.TasksWindow;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ReadTasks implements Runnable{

    String filePath;
    TasksList taskList;

    public ReadTasks(String filePath, TasksList taskList) {
        this.filePath = filePath;
        this.taskList = taskList;
    }

    @Override
    public void run() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            ArrayList<Task> tasks = (ArrayList<Task>) in.readObject();
            //AllTasksList.getInstance().setTasks(tasks);
            taskList.setTasks(tasks);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    e.getMessage() + "\n",
                    "Błąd odczytu zadań z pliku",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
