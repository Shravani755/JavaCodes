import java.util.Scanner;

interface I1_9 {
    String m1(int x); // abstract: int -> String

    default double d1(double y) { // defined: double -> double
        return y * 2.5;
    }
}

interface I2_9 {
    boolean m2(String s); // abstract: String -> boolean

    default int d2(int x) { // defined: int -> int
        return x + 1;
    }
}

abstract class AbstractBase9 {
    protected String label;

    public AbstractBase9(String label) {
        this.label = label;
    }

    abstract void show();
    abstract int compute(int x);
}

class Oops9 {
    I2_9 success(AbstractBase9 base, I1_9 i1) {
        base.show();
        System.out.println("compute(5) = " + base.compute(5));

        String r1 = i1.m1(10);
        System.out.println("m1(10) = " + r1);
        System.out.println("d1(3.0) = " + i1.d1(3.0));

        I2_9 i2 = (s) -> s.length() > 3; // lambda expression
        return i2;
    }
}

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a label for the abstract class object: ");
        String label = sc.nextLine();

        AbstractBase9 base = new AbstractBase9(label) {
            void show() {
                System.out.println("AbstractBase9 label = " + this.label);
            }
            int compute(int x) {
                return x * x;
            }
        };

        I1_9 i1 = new I1_9() {
            public String m1(int x) {
                return "Value received: " + x;
            }
        };

        Oops9 oops = new Oops9();
        I2_9 resultI2 = oops.success(base, i1);

        System.out.print("Enter a string to test m2: ");
        String testStr = sc.nextLine();
        System.out.println("m2 result: " + resultI2.m2(testStr));
        System.out.println("d2(7) result: " + resultI2.d2(7));

        sc.close();
    }
}
