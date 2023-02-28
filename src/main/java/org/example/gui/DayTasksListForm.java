package org.example.gui;

import org.example.enums.ColNames;
import org.example.tasks.AllTasksList;
import org.example.tasks.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class DayTasksListForm {

    private JPanel panel1;
    private JButton buttonChoseTask;
    private JTable tableTasks;

    private JComboBox<String> tasksComboBox;
    private JButton edytujWybraneButton;
    private JButton usunWybraneButton;
    private JLabel timeDesLabel;
    private JLabel timeLabel;
    private JButton zarzadzajAktywnosciamiButton;


    private void createUIComponents() {
        //utworzenie tabelki, w której wyświetlane będą dodane przez użytkownika zadania
        tableTasks = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) tableTasks.getModel();
        for(ColNames columnName : ColNames.values()){
            tableModel.addColumn(columnName.name());
        }
        tableModel.addColumn("Czas (min.)");
        tableTasks.setModel(tableModel);
        tableTasks.getColumnModel().getColumn(2).setMinWidth(100);
        tableTasks.getColumnModel().getColumn(2).setMaxWidth(100);

        //comboBox z dostępnymi zadaniami
        tasksComboBox = new JComboBox<>();
    }

    public DayTasksListForm(){
        TasksWindow.getInstance().getFrame().setContentPane(panel1);

        buttonChoseTask.addActionListener(e -> noweZadnieDnia());
        zarzadzajAktywnosciamiButton.addActionListener(e->zarzadzajAktywnosciami());

        AllTasksList.getInstance().getTasks().forEach(t-> tasksComboBox.addItem(t.getTitle()));
    }

    private void zarzadzajAktywnosciami() {
        new TasksListForm();
        TasksWindow.getInstance().refresh();
    }

    private void noweZadnieDnia() {
        try {
            String title;
            if(tasksComboBox.getSelectedItem() != null){
                title = Objects.requireNonNull(tasksComboBox.getSelectedItem()).toString();
            }else{
                return;
            }
            Optional<Task> task = AllTasksList.getInstance().getTaskByTitle(title);
            try{
                if(task.isPresent()){
                    System.out.println(task.get().getTitle());
                    new AddDayTaskForm("files\\dayTasks.ser", task.get());
                    TasksWindow.getInstance().refresh();
                }else{
                    throw new IOException("Nie wczytano danych zadania");
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }catch(NullPointerException e){
            e.printStackTrace();
        }

    }
}
