package org.example;

public class Logic {
    public int side = 3;
    public int length = side * side;
    public String[] array = new String[length];
    Result result = new Result(side, side, 3);

    // метод проверяет является ли игровое поле пустым(чтобы при повторным нажатием на поле не появился крестик или нолик)
    public boolean write(int index, String symbol) {
        if(array[index] == null) {
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
        result.process(array);
        int index = (int) (Math.random() * 9);
        write(index, "X");
        return false;
    }
}
