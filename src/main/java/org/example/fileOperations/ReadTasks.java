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
        try {
            System.out.println("Reading tasks from file");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            TasksList.getInstance().setTasks((ArrayList<Task>) in.readObject());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(MainWindow.getInstance().getFrame(),
                    e.getMessage(),
                    "Błąd odczytu zadań z pliku",
                    JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
