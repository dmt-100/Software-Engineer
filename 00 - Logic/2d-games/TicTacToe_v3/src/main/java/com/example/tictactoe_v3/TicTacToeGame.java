package com.example.tictactoe_v3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Button[][] buttons; // двумерный массив кнопок, представляющих клетки игрового поля в графическом интерфейсе.
    private int turn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        buttons = new Button[3][3];
        board = new Board();
        player1 = new HumanPlayer('X');
        player2 = new ComputerPlayer('O');
        currentPlayer = player1;

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonClick(button, finalRow, finalCol));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 320, 320);
        primaryStage.setTitle("Крестики-нолики");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(Button button, int row, int col) { // метод: обработчик события нажатия на кнопку. Проверяет возможность хода, обновляет игровое поле и проверяет наличие победителя или ничьей.
        if (button.getText().isEmpty() && !board.isGameOver()) {
            button.setText(Character.toString(currentPlayer.getSymbol()));
            board.makeMove(row, col, currentPlayer.getSymbol());
            turn++;

            if (turn >= 3 && board.hasWinner()) {
                showWinnerAlert(currentPlayer.getSymbol());
                resetGame();
            } else if (turn >= 3 && board.isTie()) {
                showTieAlert();
                resetGame();
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;

                if (currentPlayer instanceof ComputerPlayer computerPlayer) {
                    computerPlayer.makeMove(board);
                    int[] move = computerPlayer.getLastMove();
                    int moveRow = move[0];
                    int moveCol = move[1];
                    buttons[moveRow][moveCol].setText(Character.toString(currentPlayer.getSymbol()));

                    if (turn >= 3 && board.hasWinner()) {
                        showWinnerAlert(currentPlayer.getSymbol());
                        currentPlayer = player1;
                        resetGame();
                    } else if (turn >= 3 && board.isTie()) {
                        showTieAlert();
                        resetGame();
                    } else {
                        currentPlayer = player1;
                    }
                }
            }
        }
    }

    //  - `showWinnerAlert()`, `showTieAlert()`: методы для отображения сообщений о победителе или ничьей.
    private void showWinnerAlert(char symbol) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Победитель");
        alert.setHeaderText("Игрок " + symbol + " выиграл!");
        alert.showAndWait();
    }

    private void showTieAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ничья");
        alert.setHeaderText("Игра окончена вничью!");
        alert.showAndWait();
    }

    // брасывает состояние игры, очищает игровое поле и перезапускает игру
    private void resetGame() {
        board.reset();
        for (Button[] buttonRow : buttons) {
            for (Button button : buttonRow) {
                button.setText("");
            }
        }
    }
}

