import java.util.Scanner;

interface Outer17 {
    void abs1(int x);
    String abs2();
    default int def1(int a, int b) { return a + b; }

    interface NestedA17 { void na(); }
    interface NestedB17 { void nb(String s); }
}

class ConcreteOuter17 implements Outer17 {
    public void abs1(int x) { System.out.println("ConcreteOuter17.abs1(" + x + ")"); }
    public String abs2() { return "ConcreteOuter17.abs2() result"; }
}

public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) normal concrete class for Outer17
        Outer17 outer = new ConcreteOuter17();

        // 2) anonymous inner class for NestedA17
        Outer17.NestedA17 nestedA = new Outer17.NestedA17() {
            public void na() {
                System.out.println("NestedA17.na() via anonymous class");
            }
        };

        // 3) lambda expression for NestedB17
        Outer17.NestedB17 nestedB = (s) -> System.out.println("NestedB17.nb() via lambda: " + s);

        System.out.print("Enter an int for abs1: ");
        int x = Integer.parseInt(sc.nextLine().trim());
        outer.abs1(x);
        System.out.println(outer.abs2());

        System.out.print("Enter two ints for def1 (space separated): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        System.out.println("def1 result: " + outer.def1(a, b));

        nestedA.na();

        System.out.print("Enter a string for nb: ");
        String s = sc.nextLine();
        nestedB.nb(s);

        sc.close();
    }
}
