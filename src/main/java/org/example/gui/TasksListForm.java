package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.TasksList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

public class TasksListForm {

    private JPanel panel1;
    private JButton buttonNewTask;
    private JTable tableTasks;

    private JComboBox<String> tasksComboBox;
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
        MainWindow.getInstance().getFrame().setContentPane(panel1);

        buttonNewTask.addActionListener(e -> noweZadnie());
    }

    private void noweZadnie() {
        String task = Objects.requireNonNull(tasksComboBox.getSelectedItem()).toString();
        messageLabel.setText("");
        if(task.equals("Zadanie")){
            new AddTaskForm();
            MainWindow.getInstance().refresh();
        }else{
            System.out.println("Nieosłużone żądanie");
        }
    }
}
