import java.util.Scanner;

class Insta5 {
    private String username;
    private String password;

    public Insta5(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class User5 {
    private Insta5 insta;
    private Scanner sc;

    public User5(Insta5 insta, Scanner sc) {
        this.insta = insta;
        this.sc = sc;
    }

    public void login() {
        System.out.print("Enter password to login: ");
        String entered = sc.nextLine();

        if (entered.equals(insta.getPassword())) {
            System.out.println("Login successful!");
            changeName();
        } else {
            System.out.println("Incorrect password.");
            System.out.print("Enter a new password to reset: ");
            String newPassword = sc.nextLine();
            insta.setPassword(newPassword);
            System.out.println("Password reset successful. Please login again.");
            login();
        }
    }

    public void changeName() {
        System.out.print("Enter password to change username: ");
        String entered = sc.nextLine();

        if (entered.equals(insta.getPassword())) {
            System.out.print("Enter new username: ");
            String newUsername = sc.nextLine();
            insta.setUsername(newUsername);
            System.out.println("Username updated successfully. New username: " + insta.getUsername());
        } else {
            System.out.println("Incorrect password.");
            System.out.print("Enter a new password to reset: ");
            String newPassword = sc.nextLine();
            insta.setPassword(newPassword);
            System.out.println("Password reset. Trying to change username again...");
            changeName();
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Insta Account Setup ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Insta5 insta = new Insta5(username, password);
        User5 user = new User5(insta, sc);

        user.login();

        sc.close();
    }
}
