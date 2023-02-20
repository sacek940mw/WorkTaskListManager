package org.example.gui;

import javax.swing.*;

public class MainWindow {

    private static MainWindow instance = new MainWindow();

    private JPanel currentJPanel;
    private JFrame frame;

    private MainWindow(){
        frame = new JFrame("Zadania");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
    }

    void refresh(){
        frame.revalidate();
        frame.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getCurrentJPanel() {
        return currentJPanel;
    }

    public void setCurrentJPanel(JPanel currentJPanel) {
        this.currentJPanel = currentJPanel;
    }

    public static MainWindow getInstance(){
        return instance;
    }
}
