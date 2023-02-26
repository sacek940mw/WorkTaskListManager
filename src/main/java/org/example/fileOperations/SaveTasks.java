package org.example.fileOperations;

import org.example.gui.TasksWindow;
import org.example.tasks.AllTasksList;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveTasks implements Runnable{

    String filePath = "files\\tasks.ser";

    @Override
    public void run() {
        System.out.println("ASaving tasks to file.");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(AllTasksList.getInstance().getTasks());
            out.flush();

        } catch (IOException e) {
            //throw new RuntimeException(e);
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    e.getMessage(),
                    "Błąd zapisu zadań do pliku",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("zapisano zadania");
    }
}
