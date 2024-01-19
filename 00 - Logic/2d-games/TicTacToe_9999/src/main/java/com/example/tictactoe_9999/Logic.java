package com.example.tictactoe_9999;

public class Logic {
    public int side = 3;
    public int length = side * side;
    public String[] array = new String[length];
    Result result = new Result(side, side, 3);
    Counter counter = new Counter(result);

    public void startPosition() {
        array = new String[length];
        int index = (int)(Math.random() * length);
        array[index] = "X";
    }

    // метод сообщает кто выиграл
    public String result() {
        return result.process(array);
    }

    // метод записывает в массив
    public boolean write(int index, String symbol) {
        if(array[index] == null) { // проверяет является ли игровое поле пустым(чтобы при повторным нажатием на поле не появился крестик или нолик)
            array[index] = symbol;
        } else {
            return false;
        }
        return true;
    }

    public boolean positionUser(int index) {
        return write(index, "O");
    }

    public boolean positionPC() {
        counter.process(array);
        int index = (int)(Math.random() * length);
        write(index, "X");
        return false;
    }
}
