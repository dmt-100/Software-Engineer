package com.example.tictactoe_9999;
// https://www.youtube.com/watch?v=e-BIXQQ1Fls&list=PLUT6df5LDWkIqpWkNFzoiofAbrzp_8eVs&index=3
public class Counter {
    public Result result;
    public int index;

    public Counter() {
    }

    public Counter(Result result) {
        this.result = result;
    }

    // анализирует текущую позицию в массиве, переопределяет индекс
    public int process(String[] array) {
        recursion("O", array, -1);
        return index;
    }

    public int recursion(String symbol, String[] arrayOut, int position) {
        String[] array = arrayOut.clone();

        if (position >= 0) {
            array[position] = symbol;
        }
        if (result.process(array) == symbol) {
            return 2; // метод вернет двойку когда побеждают те кто ходит
        }
        
        print(array);

        int score = 0;
        int maxScore = -1; // самый лучший результат за противника
        int index = 0;

        for (int i = 0; i < array.length; i++) { // пробегаемся по всем точкам игрового поля
            if (array[i] == null) { // что не вызывать самого себя
                if (symbol == "O") {
                    score = recursion("X", array, i);
                }
                if (symbol == "X") {
                    score = recursion("O", array, i);
                }
                if (score > maxScore) {
                    maxScore = score;
                    index = i;
                }
            }
        }
        this.index = index;
        if (maxScore == -1) {
            return 1;
        } else {
            return 2 - maxScore;
        }
    }
    
    public void print(String[] array) {
        int i = 0;
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                if(array[i] == null) {
                    System.out.print("_ ");
                } else {
                    System.out.print(array[i] + " ");
                }
                i++;
            }
            System.out.println();
        }
        System.out.println();
    }
 

}
