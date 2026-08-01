import java.util.Scanner;

@FunctionalInterface
interface Greeting24 { String greet(String name); }

@FunctionalInterface
interface Calculator24 { int calculate(int a, int b); }

@FunctionalInterface
interface Validator24 { boolean validate(String input); }

class GreetingImpl24 implements Greeting24 {
    public String greet(String name) { return "Hello, " + name + "!"; }
}

public class Main24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Traditional approach: concrete class
        Greeting24 greeting = new GreetingImpl24();

        // 2) Anonymous inner class
        Calculator24 calculator = new Calculator24() {
            public int calculate(int a, int b) {
                return a * b;
            }
        };

        // 3) Lambda expression
        Validator24 validator = (input) -> input != null && !input.isEmpty();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println(greeting.greet(name));

        System.out.print("Enter two ints: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        System.out.println("calculate result: " + calculator.calculate(a, b));

        System.out.print("Enter a string to validate: ");
        String input = sc.nextLine();
        System.out.println("validate result: " + validator.validate(input));

        sc.close();
    }
}
