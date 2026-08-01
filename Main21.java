import java.util.Scanner;

interface I1_21 {
    String m1(int x); // abstract: int -> String

    default double d1(double y) { // defined: double -> double
        return y * 3.5;
    }
}

interface I2_21 {
    boolean m2(String s); // abstract: String -> boolean

    default int d2(int x) { // defined: int -> int
        return x - 1;
    }
}

abstract class AbstractBase21 {
    protected String label;

    public AbstractBase21(String label) {
        this.label = label;
    }

    abstract void show();
    abstract int compute(int x);
}

class Oops21 {
    I2_21 success(AbstractBase21 base, I1_21 i1) {
        base.show();
        System.out.println("compute(6) = " + base.compute(6));

        String r1 = i1.m1(20);
        System.out.println("m1(20) = " + r1);
        System.out.println("d1(4.0) = " + i1.d1(4.0));

        I2_21 i2 = (s) -> s.length() > 2; // lambda expression
        return i2;
    }
}

public class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a label for the abstract class object: ");
        String label = sc.nextLine();

        AbstractBase21 base = new AbstractBase21(label) {
            void show() {
                System.out.println("AbstractBase21 label = " + this.label);
            }
            int compute(int x) {
                return x * x * x;
            }
        };

        I1_21 i1 = new I1_21() {
            public String m1(int x) {
                return "Received value: " + x;
            }
        };

        Oops21 oops = new Oops21();
        I2_21 resultI2 = oops.success(base, i1);

        System.out.print("Enter a string to test m2: ");
        String testStr = sc.nextLine();
        System.out.println("m2 result: " + resultI2.m2(testStr));
        System.out.println("d2(9) result: " + resultI2.d2(9));

        sc.close();
    }
}
