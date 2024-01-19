public class Recursion2 {

    public static void main(String[] args) {
        recursion(0);
    }

    public static void recursion(int i) {
        System.out.println("вызван recusion " + i);

        if (i < 3450) {recursion(i + 1);}

        System.out.println("отработал recursion " + i);
    }
}
