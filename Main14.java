import java.util.Scanner;

abstract class Account14 {
    protected double balance;

    public Account14(double balance) {
        this.balance = balance;
    }

    void info() {
        System.out.println("Balance: " + balance);
    }

    abstract void withdraw(double amount);
}

interface Notifier14 {
    void notify(String msg);
    default void log(String msg) { System.out.println("[LOG] " + msg); }
}

interface RateProvider14 {
    double rate(double principal);
    default double bonus(double principal) { return principal * 0.01; }
}

public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        double balance = Double.parseDouble(sc.nextLine().trim());

        // No 'extends' keyword used - anonymous subclass of an abstract class
        Account14 account = new Account14(balance) {
            void withdraw(double amount) {
                if (amount <= this.balance) {
                    this.balance -= amount;
                    System.out.println("Withdrew " + amount + ", remaining: " + this.balance);
                } else {
                    System.out.println("Insufficient balance.");
                }
            }
        };

        // No 'implements' keyword used - anonymous implementations of interfaces
        Notifier14 notifier = new Notifier14() {
            public void notify(String msg) {
                System.out.println("Notification: " + msg);
            }
        };

        RateProvider14 rateProvider = new RateProvider14() {
            public double rate(double principal) {
                return principal * 0.05;
            }
        };

        account.info();
        System.out.print("Enter amount to withdraw: ");
        double amt = Double.parseDouble(sc.nextLine().trim());
        account.withdraw(amt);

        notifier.notify("Withdrawal processed");
        notifier.log("Transaction complete");

        System.out.println("rate() result: " + rateProvider.rate(balance));
        System.out.println("bonus() result: " + rateProvider.bonus(balance));

        sc.close();
    }
}
