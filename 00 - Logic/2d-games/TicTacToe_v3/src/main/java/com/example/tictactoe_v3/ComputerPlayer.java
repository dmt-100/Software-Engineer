package com.example.tictactoe_v3;

import java.util.Random;

public class ComputerPlayer extends Player {
    private int[] lastMove; // массив для хранения последнего хода компьютера

    public ComputerPlayer(char symbol) {
        super(symbol);
    }

    // возвращает последний сделанный ход компьютера
    public int[] getLastMove() {
        return lastMove;
    }

//    // генерирует случайное число для выполнения хода компьютера и обновляет игровое поле
//    @Override
//    public void makeMove(Board board) {
//        int bestScore = Integer.MIN_VALUE;
//        int bestRow = -1;
//        int bestCol = -1;
//
//        // Проходим по всем свободным клеткам на игровом поле
//        for (int row = 0; row < board.getSize(); row++) {
//            for (int col = 0; col < board.getSize(); col++) {
//                if (board.isEmpty(row, col)) {
//                    // Попробуем сделать ход в эту клетку
//                    board.setSymbol(row, col, getComputerSymbol());
//
//                    // Вычисляем оценку этого хода с помощью минимакс алгоритма
//                    int score = minimax(board, 0, false);
//
//                    // Отменяем ход для проверки следующей клетки
//                    board.setSymbol(row, col, Board.EMPTY_SYMBOL);
//
//                    // Если оценка текущего хода лучше, обновляем значения
//                    if (score > bestScore) {
//                        bestScore = score;
//                        bestRow = row;
//                        bestCol = col;
//                    }
//                }
//            }
//        }
//
//        // Устанавливаем символ компьютера в наилучшую клетку
//        board.setSymbol(bestRow, bestCol, getComputerSymbol());
//    }

    @Override
    public void makeMove(Board board) {
        Random random = new Random();
        int row;
        int col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isValidMove(row, col));

        lastMove = new int[]{row, col};
        board.makeMove(row, col, symbol);
    }
}

