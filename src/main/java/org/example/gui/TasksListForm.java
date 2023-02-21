package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.TasksList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TasksListForm {

    private JPanel panel1;
    private JButton buttonNewTask;
    private JTable tableTasks;

    private JLabel messageLabel;
    private JButton edytujWybraneButton;
    private JButton usunWybraneButton;

    private void createUIComponents() {
        //utworzenie tabelki, w której wyświetlane będą dodane przez użytkownika zadania
        tableTasks = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) tableTasks.getModel();
        for(ColNames columnName : ColNames.values()){
            tableModel.addColumn(columnName.name());
        }

        //dodanie wierszy tabeli
        TasksList tl = TasksList.getInstance();
        tl.getTasks().forEach(t -> tableModel.addRow(new Object[]{t.getTitle(), t.getDescription()}));

        tableTasks.setModel(tableModel);
        System.out.println("UI create");
    }

    public TasksListForm(){
        TasksWindow.getInstance().getFrame().setContentPane(panel1);

        buttonNewTask.addActionListener(e -> noweZadnie());
        usunWybraneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void noweZadnie() {
        new AddTaskForm();
        TasksWindow.getInstance().refresh();
    }
}
