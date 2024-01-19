package org.example;

public class Result {
    int width;
    int height;
    int distance;
    private String[] array;

    public Result(int width, int height, int distance) {
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    public String process(String[] array) {
        this.array = array;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                for (int b = -1; b <= +1; b++) {
                    for (int a = -1; a <= +1; a++) {
                        if (!(a == 0 && b == 0)) {

                            if (check(x, y, a, b, "X")) {
                                System.out.println("X-WIN");
                            }
                            if (check(x, y, a, b, "O")) {
                                System.out.println("O-WIN");
                            }
                        }
                    }
                }
            }
        }
        return "Draw";
    }

    // метод проверяет 3 крестика или три нолика в каком-то напралении
    public boolean check(int x, int y, int a, int b, String symbol) {
        for (int i = 0; i < distance; i++) {
            int index = border(x + a * i, y + b * i);
            if(index == -1) {
                return false;
            } else if (array[index] != symbol) {
                return false;
            }
        }
        return true;
    }

    public int border(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return y * width + x; //переводит координаты x, y в одномерную величину
        }
        return -1;
    }

}
