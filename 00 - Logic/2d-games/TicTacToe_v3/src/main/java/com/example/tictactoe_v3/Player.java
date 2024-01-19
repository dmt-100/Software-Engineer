package com.example.tictactoe_v3;

public abstract class Player {
    protected char symbol; // переменная для хранения символа игрока (крестик или нолик)

    public Player(char symbol) {
        this.symbol = symbol;
    }

    // возвращает символ игрока
    public char getSymbol() {
        return symbol;
    }

    // абстрактный метод, который должен быть реализован в подклассах. Используется для выполнения хода игрока
    public abstract void makeMove(Board board);
}

