package com.example.tictactoe_v3;

public class HumanPlayer extends Player {
    public HumanPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public void makeMove(Board board) {
        // Игрок-человек выполняет ход с помощью графического интерфейса,
        // ничего не нужно делать здесь
    }
}

