import java.util.Scanner;

class Chain29 {
    int m1(int x) {
        System.out.println("m1 called with " + x);
        return x * 2;
    }

    int m2(int x) {
        System.out.println("m2 called with " + x);
        int result = m1(x);
        return result + 10;
    }

    boolean m3(int x) {
        System.out.println("m3 called with " + x);
        int result = m2(x);
        return result > 20;
    }
}

public class Main29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = Integer.parseInt(sc.nextLine().trim());

        Chain29 chain = new Chain29();
        boolean result = chain.m3(x); // only m3() invoked here; m3 -> m2 -> m1 internally

        System.out.println("Final result from m3(): " + result);

        sc.close();
    }
}
