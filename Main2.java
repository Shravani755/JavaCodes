class Animal {
    String type = "Animal";

    Animal() {
        System.out.println("Animal no-arg constructor called");
    }

    void sound() {
        System.out.println("Animal makes a generic sound");
    }
}

class Dog extends Animal {
    String type = "Dog"; // shadows Animal's "type" field
    String name;

    // this keyword at constructor level: chains to Dog(String)
    Dog() {
        this("Unnamed");
        System.out.println("Dog no-arg constructor called");
    }

    Dog(String name) {
        super(); // explicit call to Animal's constructor
        this.name = name; // this keyword at variable level: resolves param vs field
        System.out.println("Dog(String) constructor called, name=" + this.name);
    }

    // super keyword at method level: invokes Animal's overridden method
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }

    void showTypes() {
        // super keyword at variable level: accesses Animal's shadowed field
        System.out.println("this.type (Dog)   = " + this.type);
        System.out.println("super.type (Animal) = " + super.type);
    }
}

public class Main2 {

    public static void main(String[] args) {
        System.out.println("=== main(String[] args) invoked ===");
        Dog d = new Dog();
        d.sound();
        d.showTypes();

        System.out.println("\n=== Demonstrating overloaded main methods ===");
        main("Hello Java");
        main(42);
        main();
    }

    // Overload 1: takes a single String
    public static void main(String arg) {
        System.out.println("main(String) called with: " + arg);
    }

    // Overload 2: takes an int
    public static void main(int arg) {
        System.out.println("main(int) called with: " + arg);
    }

    // Overload 3: no arguments
    public static void main() {
        System.out.println("main() called with no arguments");
    }
}
