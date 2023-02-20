package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.TasksList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TasksListForm {

    private JPanel panel1;
    private JButton buttonNewTask;
    private JTable tableTasks;
    private JComboBox tasksComboBox;

    private void createUIComponents() {
        // TODO: place custom component creation code here

        //utworzenie tabelki, w której wyświetlane będą dodane przez użytkownika zadania
        tableTasks = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) tableTasks.getModel();
        for(ColNames columnName : ColNames.values()){
            tableModel.addColumn(columnName.name());
        }
        tableTasks.setModel(tableModel);
    }

    public TasksListForm(){
        MainWindow.getInstance().getFrame().setContentPane(panel1);

        buttonNewTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noweZadnie();
            }
        });

    }

    private void noweZadnie() {
        String task = tasksComboBox.getSelectedItem().toString();
        switch (task){
            case "Zadanie":
                AddTaskForm addTaskForm = new AddTaskForm();
                //frame.setContentPane(addTaskForm.getTaskPanel());
                MainWindow.getInstance().refresh();

                break;
            default:
                System.out.println("Nieosłużone żądanie");
        }
    }
}
