package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private int index;
    private Logic logic = new Logic();
    private MyFrame myFrame;

    public Button(int index, int x, int y, Logic logic, MyFrame myFrame) {
        this.index = index;
        this.logic = logic;
        this.myFrame = myFrame;

        this.setBounds(x * 100, y * 100, 100, 100); // 0, 0; 0, 100; 0, 200;...
        this.addActionListener(new MyKeyAdapter());
    }

    // у каждой кнопки свой слушатель
    private class MyKeyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            logic.positionUser(index);
            myFrame.update();

            logic.positionPC();
            myFrame.update();
        }
    }

}
