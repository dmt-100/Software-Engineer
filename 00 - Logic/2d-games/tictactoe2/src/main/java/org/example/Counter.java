package org.example;

public class Counter {
    public Result result;
    public int index;

    public Counter(Result result) {
        this.result = result;
    }

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
            return 2;
        }

        int score = 0;
        int maxScore = -1;
        int idex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
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


}
