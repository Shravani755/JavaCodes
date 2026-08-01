import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the lower bound: ");
        int start = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter the upper bound: ");
        int end = Integer.parseInt(sc.nextLine().trim());

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        System.out.println("Prime numbers between " + start + " and " + end + ":");
        boolean anyFound = false;
        for (int num = Math.max(start, 2); num <= end; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                anyFound = true;
            }
        }
        if (!anyFound) {
            System.out.println("No prime numbers found in this range.");
        } else {
            System.out.println();
        }

        sc.close();
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
