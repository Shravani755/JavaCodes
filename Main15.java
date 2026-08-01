import java.util.Scanner;

interface Outer15 {
    void abs1();
    int abs2(String s);

    default int def1(int x) {
        class Inner1_15 {
            int val;
            Inner1_15(int v) { val = v; }
            int getVal() { return val * 2; }
        }
        Inner1_15 inner = new Inner1_15(x);
        return inner.getVal();
    }

    default String def2(String s) {
        abstract class InnerAbs15 {
            abstract String process(String s);
        }
        InnerAbs15 ia = new InnerAbs15() {
            String process(String s) {
                return s.toUpperCase();
            }
        };
        return ia.process(s);
    }

    interface NestedInterface15 {
        void nAbs();
        default void nDef() {
            System.out.println("NestedInterface15 default nDef()");
        }
    }
}

public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Outer15 outer = new Outer15() {
            public void abs1() {
                System.out.println("Outer15.abs1() implemented");
            }
            public int abs2(String s) {
                return s.length();
            }
        };

        Outer15.NestedInterface15 nested = new Outer15.NestedInterface15() {
            public void nAbs() {
                System.out.println("NestedInterface15.nAbs() implemented");
            }
        };

        outer.abs1();
        System.out.print("Enter a string for abs2: ");
        String s = sc.nextLine();
        System.out.println("abs2 result: " + outer.abs2(s));

        System.out.print("Enter an int for def1: ");
        int x = Integer.parseInt(sc.nextLine().trim());
        System.out.println("def1 result: " + outer.def1(x));

        System.out.println("def2 result: " + outer.def2(s));

        nested.nAbs();
        nested.nDef();

        sc.close();
    }
}
