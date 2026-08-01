import java.util.Scanner;

class Gmail16 {
    private String email;
    private String password;

    public Gmail16(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class User16 {
    private Gmail16 gmail;

    public User16(Gmail16 gmail) {
        this.gmail = gmail;
    }

    void viewDetails() {
        System.out.println("Email: " + gmail.getEmail());
        System.out.println("Password: " + gmail.getPassword());
    }

    void resetPassword(Scanner sc) {
        System.out.print("Enter new password: ");
        String newPassword = sc.nextLine();
        gmail.setPassword(newPassword);
        System.out.println("Password reset successful.");
    }
}

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gmail Account Setup ===");
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Gmail16 gmail = new Gmail16(email, password);
        User16 user = new User16(gmail);

        System.out.println("\n1. View Details\n2. Reset Password");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        if (choice == 1) {
            user.viewDetails();
        } else if (choice == 2) {
            user.resetPassword(sc);
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
