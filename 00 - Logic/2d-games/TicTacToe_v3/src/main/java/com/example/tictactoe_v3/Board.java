package com.example.tictactoe_v3;

public class Board {
    private char[][] grid; // игровое поле
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
    }

    // устанавливает символ игрока в указанную клетку
    public void makeMove(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    // проверяет, что указанная клетка является допустимым ходом
    public boolean isValidMove(int row, int col) {
        return (row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == '\u0000');
    }

    // проверяет наличие победителя, проверяя горизонтальные, вертикальные и диагональные линии
    public boolean hasWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][0] != '\u0000' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }

            if (grid[0][i] != '\u0000' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                return true;
            }
        }

        // Проверяем диагональные линии
        if (grid[0][0] != '\u0000' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }

        if (grid[0][2] != '\u0000' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return true;
        }

        return false;
    }

    // проверяет, наступила ли ничья
    public boolean isTie() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return hasWinner() || isTie();
    }

    // сбрасывает состояние игрового поля
    public void reset() {
        grid = new char[SIZE][SIZE];
    }

    // возвращает строковое представление игрового поля для вывода в консоль
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '\u0000') {
                    sb.append("-");
                } else {
                    sb.append(grid[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

