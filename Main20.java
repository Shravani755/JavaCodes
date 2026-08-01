import java.util.Scanner;

interface First20 { int op(int a, int b); default String label() { return "First20"; } }
interface Second20 { String op(String s); default int length(String s) { return s.length(); } }
interface Third20 { double op(double d); default double half(double d) { return d / 2; } }

class FirstImpl20 implements First20 {
    public int op(int a, int b) { return a + b; }
}

public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) concrete class
        First20 first = new FirstImpl20();

        // 2) anonymous inner class
        Second20 second = new Second20() {
            public String op(String s) {
                return s.toUpperCase();
            }
        };

        // 3) lambda expression
        Third20 third = (d) -> d * d;

        System.out.print("Enter two ints: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        System.out.println(first.label() + " op result: " + first.op(a, b));

        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Second20 op result: " + second.op(s));
        System.out.println("Second20 length result: " + second.length(s));

        System.out.print("Enter a double: ");
        double d = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Third20 op result: " + third.op(d));
        System.out.println("Third20 half result: " + third.half(d));

        sc.close();
    }
}
