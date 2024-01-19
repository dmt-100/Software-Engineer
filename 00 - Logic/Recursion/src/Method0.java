public class Method0 {
    public static void main(String[] args) {
        method0();
    }

    public static void method0() {
        System.out.println("method0 вызван");
        method1();
        System.out.println("method0 отработал");
    }
    public static void method1() {
        System.out.println("method1 вызван");
        method2();
        System.out.println("method1 отработал");
    }
    public static void method2() {
        System.out.println("method2 вызван и отработал");
    }
}
