import java.util.Scanner;

abstract class Library25 {
    protected String bookTitle;

    public Library25(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    void info() {
        System.out.println("Book: " + bookTitle);
    }

    abstract void issue();
}

interface Notifier25 {
    void notify(String msg);
    default void log(String msg) { System.out.println("[LOG] " + msg); }
}

interface FineCalculator25 {
    double calculateFine(int daysLate);
    default double waiver(double fine) { return fine * 0.5; }
}

public class Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        // No 'extends' keyword used - anonymous subclass of an abstract class
        Library25 library = new Library25(title) {
            void issue() {
                System.out.println(bookTitle + " has been issued.");
            }
        };

        // No 'implements' keyword used - anonymous implementations of interfaces
        Notifier25 notifier = new Notifier25() {
            public void notify(String msg) {
                System.out.println("Notification: " + msg);
            }
        };

        FineCalculator25 fineCalculator = new FineCalculator25() {
            public double calculateFine(int daysLate) {
                return daysLate * 2.0;
            }
        };

        library.info();
        library.issue();

        notifier.notify("Book issue processed");
        notifier.log("Transaction complete");

        System.out.print("Enter number of days late: ");
        int daysLate = Integer.parseInt(sc.nextLine().trim());
        double fine = fineCalculator.calculateFine(daysLate);
        System.out.println("calculateFine result: " + fine);
        System.out.println("waiver result: " + fineCalculator.waiver(fine));

        sc.close();
    }
}
