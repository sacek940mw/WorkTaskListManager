package org.example.fileOperations;

import org.example.gui.MainWindow;
import org.example.tasks.Task;
import org.example.tasks.TasksList;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ReadTasks implements Runnable{

    String filePath = "files\\tasks.ser";

    @Override
    public void run() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            ArrayList<Task> tasks = (ArrayList<Task>) in.readObject();
            TasksList.getInstance().setTasks(tasks);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(MainWindow.getInstance().getFrame(),
                    e.getMessage() + "\n",
                    "Błąd odczytu zadań z pliku",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
