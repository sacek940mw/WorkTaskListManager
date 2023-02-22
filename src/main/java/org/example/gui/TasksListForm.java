package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.TasksList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    }

    public TasksListForm(){
        TasksWindow.getInstance().getFrame().setContentPane(panel1);

        buttonNewTask.addActionListener(e -> newTask());
        usunWybraneButton.addActionListener(e -> removeSelectedTasks());
        edytujWybraneButton.addActionListener(e -> editSelectedTask());
    }

    private void editSelectedTask() {
        if(tableTasks.getSelectedRowCount()>1){
            JOptionPane.showMessageDialog(TasksWindow.getInstance().getFrame(),
                    "Wybierz jedno zadanie do edycji.",
                    "Błąd edycji zadania",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = tableTasks.getSelectedRow();
        String title = tableTasks.getModel().getValueAt(row,0).toString();
    }

    private void removeSelectedTasks() {
        int[] rows = tableTasks.getSelectedRows();
        for(int r : rows){
            String title = tableTasks.getModel().getValueAt(r,0).toString();
            TasksList.getInstance().removeTask(title);
        }
        createUIComponents();
        TasksWindow.getInstance().refresh();
    }

    private void newTask() {
        new AddTaskForm();
        TasksWindow.getInstance().refresh();
    }
}
