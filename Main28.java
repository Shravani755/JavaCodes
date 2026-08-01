import java.util.Scanner;

class Shape28 {
    String type;

    Shape28() { // constructor overload 1
        this.type = "Shape"; // this keyword at variable level
    }

    Shape28(String type) { // constructor overload 2 (constructor overloading)
        this.type = type; // this keyword at variable level
    }

    void display() {
        System.out.println("this.type = " + this.type);
        this.describe(); // this keyword at method overriding: resolves polymorphically at runtime
    }

    void describe() {
        System.out.println("I am a generic shape.");
    }
}

class Circle28 extends Shape28 {
    Circle28(String type) {
        super(type);
    }

    @Override
    void describe() {
        System.out.println("I am a circle, type=" + this.type);
    }
}

public class Main28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter shape type: ");
        String type = sc.nextLine();

        Shape28 shape1 = new Shape28(); // no-arg constructor
        shape1.display();

        Shape28 shape2 = new Circle28(type); // parameterized constructor via subclass
        shape2.display(); // display() -> this.describe() dispatches to Circle28's override

        sc.close();
    }
}
