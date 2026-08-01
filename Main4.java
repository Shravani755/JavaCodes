import java.util.Scanner;

interface Operation4 {
    int apply(int a, int b); // abstract method

    default String describe(String opName) { // default method 1: String -> String
        return "Operation: " + opName;
    }

    default double scale(double value, int factor) { // default method 2: (double,int) -> double
        return value * factor;
    }
}

// a) normal concrete class
class AddOperation4 implements Operation4 {
    public int apply(int a, int b) {
        return a + b;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter second number: ");
        int b = Integer.parseInt(sc.nextLine().trim());

        // a) concrete class
        Operation4 addOp = new AddOperation4();
        System.out.println(addOp.describe("Addition"));
        System.out.println("Concrete class result: " + addOp.apply(a, b));
        System.out.println("Scaled: " + addOp.scale(a, 2));

        // b) anonymous inner class
        Operation4 subOp = new Operation4() {
            public int apply(int a, int b) {
                return a - b;
            }
        };
        System.out.println(subOp.describe("Subtraction"));
        System.out.println("Anonymous class result: " + subOp.apply(a, b));
        System.out.println("Scaled: " + subOp.scale(b, 3));

        // c) lambda expression
        Operation4 mulOp = (x, y) -> x * y;
        System.out.println(mulOp.describe("Multiplication"));
        System.out.println("Lambda result: " + mulOp.apply(a, b));
        System.out.println("Scaled: " + mulOp.scale(a, 4));

        sc.close();
    }
}
