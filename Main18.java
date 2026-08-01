import java.util.Scanner;

class Facebook18 {
    private String email;
    private String password;

    public Facebook18(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class User18 {
    void run(Scanner sc) {
        System.out.println("=== Facebook Account Setup ===");
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Facebook18 fb = new Facebook18(email, password);

        System.out.println("\nAccount Details:");
        System.out.println("Email: " + fb.getEmail());
        System.out.println("Password: " + fb.getPassword());

        System.out.print("\nDo you want to change the password? (yes/no): ");
        String choice = sc.nextLine().trim().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Enter new password: ");
            String newPassword = sc.nextLine();
            fb.setPassword(newPassword);
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password unchanged.");
        }

        System.out.println("\nFinal Account Details:");
        System.out.println("Email: " + fb.getEmail());
        System.out.println("Password: " + fb.getPassword());
    }
}

public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new User18().run(sc);
        sc.close();
    }
}
