package org.example.gui;

import org.example.enums.ColNames;
import org.example.fileOperations.SaveTasks;
import org.example.tasks.Task;
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
    }

    public TasksListForm(){
        TasksWindow.getInstance().getFrame().setContentPane(panel1);

        buttonNewTask.addActionListener(e -> newTask());
        usunWybraneButton.addActionListener(e -> removeSelectedTasks());
        edytujWybraneButton.addActionListener(e -> editTask());
    }

    private void removeSelectedTasks() {
        Object[] options = { "TAK", "NIE" };
        int pane = JOptionPane.showOptionDialog(null, "Czy na pewno chcesz trwale usunąć wybrane zadania?", "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if(pane == JOptionPane.YES_OPTION){
            int[] rows = tableTasks.getSelectedRows();
            for(int r : rows){
                String title = tableTasks.getModel().getValueAt(r,0).toString();
                TasksList.getInstance().removeTask(title);
            }
            Thread st = new Thread(new SaveTasks());
            st.start();
            try {
                st.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            new TasksListForm();
            TasksWindow.getInstance().refresh();
        }
    }

    private void newTask() {
        new TaskForm();
        TasksWindow.getInstance().refresh();
    }

    private void editTask() {
    }
}
