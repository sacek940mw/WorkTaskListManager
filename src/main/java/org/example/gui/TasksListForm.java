package org.example.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TasksListForm {
    private JPanel panel1;
    private JButton buttonNewTask;
    private JTable tableTasks;
    private JComboBox tasksComboBox;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //DefaultTableModel tableModel = new DefaultTableModel();
        tableTasks = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) tableTasks.getModel();
        for(ColNames columnName : ColNames.values()){
            tableModel.addColumn(columnName.name());
        }
        tableTasks.setModel(tableModel);
    }

    public TasksListForm(){
        JFrame frame = new JFrame("Lista dodanych zdań");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setContentPane(panel1);
        frame.setVisible(true);

        buttonNewTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noweZadnie();
            }
        });
    }

    private void noweZadnie() {
        String task = tasksComboBox.getSelectedItem().toString();
        System.out.println(task);
        switch (task){
            case "Zadanie":
                AddTaskForm addTaskForm = new AddTaskForm();
                break;
            default:
                System.out.println("Nieosłużone żądanie");
        }
    }
}
