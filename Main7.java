import java.util.Scanner;

abstract class Vehicle7 {
    protected String name;

    public Vehicle7(String name) {
        this.name = name;
    }

    void info() {
        System.out.println("Vehicle: " + name);
    }

    abstract void start();
}

interface Interface1_7 {
    void method1(String msg);

    default void greet() {
        System.out.println("Hello from Interface1_7!");
    }
}

interface Interface2_7 {
    int method2(int x);

    default int compute(int x) {
        return x * x;
    }
}

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vehicle name: ");
        String vname = sc.nextLine();

        // No 'extends' keyword used - anonymous subclass of an abstract class
        Vehicle7 vehicle = new Vehicle7(vname) {
            void start() {
                System.out.println(name + " has started.");
            }
        };

        // No 'implements' keyword used - anonymous implementations of interfaces
        Interface1_7 i1 = new Interface1_7() {
            public void method1(String msg) {
                System.out.println("method1 says: " + msg);
            }
        };

        Interface2_7 i2 = new Interface2_7() {
            public int method2(int x) {
                return x + 100;
            }
        };

        vehicle.info();
        vehicle.start();

        i1.method1("Dynamic message");
        i1.greet();

        System.out.print("Enter a number for interface2 methods: ");
        int num = Integer.parseInt(sc.nextLine().trim());
        System.out.println("method2 result: " + i2.method2(num));
        System.out.println("compute result: " + i2.compute(num));

        sc.close();
    }
}
