package org.example;

import javax.swing.*;

public class MyFrame extends JFrame {
    public Logic logic = new Logic();
    public Button[] buttons = new Button[logic.length];

    public MyFrame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350,350);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel); // добавили панель на окно, где будут располагаться кнопки

        int index = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panel.add(buttons[index] = new Button(index, x, y, logic, this));
                index++; // нумерация кнопок (х, у - что бы знали где расположены)
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame();
            }
        });
    }

    void update() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(logic.array[i]);
        }
    }
}
