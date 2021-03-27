package test;

import javax.swing.*;

public class Okno extends JFrame {
    public Panel panel;

    public Okno() {
        panel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10,10,600,600);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("litery");

    }
}