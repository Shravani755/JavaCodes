import java.util.Scanner;

interface Printable {
    void showMessage(String text);
    int countLength(String text);
}

interface MathOps {
    int add(int a, int b);
    double average(int a, int b);
}

abstract class ShapeInfo {
    private String name;

    public ShapeInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateArea(double dimension);
}

class SmartDevice extends ShapeInfo implements Printable, MathOps {
    public SmartDevice(String name) {
        super(name);
    }

    @Override
    public void showMessage(String text) {
        System.out.println("Message: " + text);
    }

    @Override
    public int countLength(String text) {
        return text.length();
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public double average(int a, int b) {
        return (a + b) / 2.0;
    }

    @Override
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter shape name: ");
        String shapeName = scanner.nextLine();

        System.out.print("Enter message: ");
        String message = scanner.nextLine();

        System.out.print("Enter first number: ");
        int first = scanner.nextInt();

        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        SmartDevice device = new SmartDevice(shapeName);

        device.showMessage(message);
        System.out.println("Message length: " + device.countLength(message));
        System.out.println("Sum: " + device.add(first, second));
        System.out.println("Average: " + device.average(first, second));
        System.out.println("Shape name: " + device.getName());
        System.out.println("Area: " + device.calculateArea(radius));

        scanner.close();
    }
}
