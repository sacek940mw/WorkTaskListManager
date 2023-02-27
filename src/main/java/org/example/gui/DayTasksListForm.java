package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.AllTasksList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

public class DayTasksListForm {

    private JPanel panel1;
    private JButton buttonChoseTask;
    private JTable tableTasks;

    private JComboBox<String> tasksComboBox;
    private JButton edytujWybraneButton;
    private JButton usunWybraneButton;
    private JLabel timeDesLabel;
    private JLabel timeLabel;
    private JButton aktywnościButton;


    private void createUIComponents() {
        //utworzenie tabelki, w której wyświetlane będą dodane przez użytkownika zadania
        tableTasks = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) tableTasks.getModel();
        for(ColNames columnName : ColNames.values()){
            tableModel.addColumn(columnName.name());
        }
        tableModel.addColumn("Czas (min.)");

        tasksComboBox = new JComboBox<>();

        tableTasks.setModel(tableModel);
        System.out.println("UI create");
    }

    public DayTasksListForm(){
        TasksWindow.getInstance().getFrame().setContentPane(panel1);

        buttonChoseTask.addActionListener(e -> noweZadnie());

        AllTasksList.getInstance().getTasks().forEach(t->{
            tasksComboBox.addItem(t.getTitle());
        });
    }

    private void noweZadnie() {
        String task = Objects.requireNonNull(tasksComboBox.getSelectedItem()).toString();
        if(task.equals("Zadanie")){
            new AddTaskForm();
            TasksWindow.getInstance().refresh();
        }else{
            System.out.println("Nieobsłużone żądanie");
        }
    }
}
