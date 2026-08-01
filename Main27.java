import java.util.Scanner;

abstract class Outer27 {
    void definedMethod() {
        System.out.println("Outer27.definedMethod() called");
    }

    abstract void abstractMethod(String msg);

    interface Inner27 {
        void abs();
        static int staticMethod(int x, int y) {
            return x + y;
        }
    }
}

public class Main27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String msg = sc.nextLine();

        // Anonymous Inner Class for the abstract class
        Outer27 outer = new Outer27() {
            void abstractMethod(String msg) {
                System.out.println("Anonymous abstractMethod: " + msg);
            }
        };
        outer.definedMethod();
        outer.abstractMethod(msg);

        // Lambda Expression for the inner interface
        Outer27.Inner27 inner = () -> System.out.println("Inner27.abs() via lambda");
        inner.abs();

        System.out.print("Enter two ints for staticMethod: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        System.out.println("staticMethod result: " + Outer27.Inner27.staticMethod(x, y));

        sc.close();
    }
}
