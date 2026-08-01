import java.util.Scanner;

class Base30 {
    String name;

    Base30(String name) {
        this.name = name; // this keyword at variable level
        System.out.println("Base30 constructor called with name=" + name);
    }

    Base30() {
        this("DefaultBase"); // this keyword at constructor level
    }

    void show() {
        System.out.println("Base30.show(), name=" + name);
    }
}

class Derived30 extends Base30 {
    Derived30(String name) {
        super(name); // super keyword at constructor level
        System.out.println("Derived30 constructor called");
    }

    @Override
    void show() {
        super.show(); // super keyword at method level
        System.out.println("Derived30.show()");
    }
}

public class Main30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = sc.nextLine();

        Derived30 obj = new Derived30(name);
        obj.show();

        sc.close();
    }
}
