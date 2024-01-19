package com.example.tictactoe_9999;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private int index;
    private Logic logic;
    private MyFrame myFrame;

    public Button(int index, int x, int y, Logic logic, MyFrame myFrame) {
        this.index = index;
        this.logic = logic;
        this.myFrame = myFrame;

        this.setBounds(x * 100, y * 100, 100, 100); // 0, 0; 0, 100; 0, 200;...
        this.addActionListener(new MyKeyAdapter());
    }

    public void action(String text) {
        JOptionPane.showMessageDialog(null, text);
        logic.startPosition(); // для очистки позиции
        myFrame.update();
    }

    public boolean result(String symbol) {
        if (symbol == "X") {
            action("YOU LOST");
            return true;
        }
        if (symbol == "O") {
            action("YOU WON");
            return true;
        }
        if (symbol == "daedlock") {
            action("DRAW");
            return true;
        }
        return false;
    }

    // у каждой кнопки свой слушатель
    private class MyKeyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            logic.positionUser(index); // отправляем индекс кнопки
            myFrame.update();
            if (result(logic.result())) {
                return;
            }

            logic.positionPC();
            myFrame.update();
            if (result(logic.result())) {
                return;
            }
        }
    }

}
