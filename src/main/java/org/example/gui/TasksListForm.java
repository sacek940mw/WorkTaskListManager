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
    private JPanel currentJPanel;
    private JPanel panel1;
    private JButton buttonNewTask;
    private JTable tableTasks;
    private JComboBox tasksComboBox;

    private JFrame frame;

    private AddTaskForm addTaskForm;

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
        frame = new JFrame("Lista dodanych zdań");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        currentJPanel = panel1;
        frame.setContentPane(currentJPanel);
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
        switch (task){
            case "Zadanie":
                addTaskForm = new AddTaskForm();
                frame.setContentPane(addTaskForm.getTaskPanel());
                frame.revalidate();
                frame.repaint();

                break;
            default:
                System.out.println("Nieosłużone żądanie");
        }
    }

    private void refreshWindow(){
        System.out.println("Window refresh");
        tableTasks.removeAll();
        DefaultTableModel dtm = (DefaultTableModel) tableTasks.getModel();
        TasksList.getInstance().getTasks().stream().forEach(t -> dtm.addRow(new Object[]{t.getTitle(),t.getTime()}));
        frame.getContentPane().repaint();
        frame.getContentPane().repaint();
    }
}
