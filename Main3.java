import java.util.Scanner;

class InvalidPasswordUpdateException3 extends Exception {
    public InvalidPasswordUpdateException3(String message) {
        super(message);
    }
}

class Gmail3 {
    private String email;
    private String password;
    private String mobileNumber;

    public Gmail3(String email, String password, String mobileNumber) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}

class User3 {
    private Gmail3 gmail;

    public User3(Gmail3 gmail) {
        this.gmail = gmail;
    }

    public void update(Scanner sc) throws InvalidPasswordUpdateException3 {
        String enteredMobile;
        while (true) {
            System.out.print("Enter your mobile number (10 digits): ");
            enteredMobile = sc.nextLine().trim();
            if (enteredMobile.matches("\\d{10}")) {
                break;
            }
            System.out.println("Invalid format. Mobile number must contain exactly 10 digits. Try again.");
        }

        if (enteredMobile.equals(gmail.getMobileNumber())) {
            System.out.print("Mobile verified. Enter new password: ");
            String newPassword = sc.nextLine();
            gmail.setPassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            throw new InvalidPasswordUpdateException3("Mobile Number is incorrect, you're not allowed to update password.");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gmail Account Setup ===");
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter mobile number (10 digits): ");
        String mobile = sc.nextLine();

        Gmail3 gmail = new Gmail3(email, password, mobile);
        User3 user = new User3(gmail);

        System.out.println("\n=== Update Password ===");
        try {
            user.update(sc);
        } catch (InvalidPasswordUpdateException3 e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
