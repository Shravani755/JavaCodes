import java.util.Scanner;

class Gmail31 {
    private String username;
    private String email;
    private String password;
    private String mobile;

    public Gmail31(String username, String email, String password, String mobile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getMobile() { return mobile; }
}

// Wrapper types so the two login overloads have genuinely distinct parameter types
class Mobile31 {
    String value;
    Mobile31(String value) { this.value = value; }
}

class Email31 {
    String value;
    Email31(String value) { this.value = value; }
}

class User31 {
    private Gmail31 account;

    public User31(Gmail31 account) {
        this.account = account;
    }

    boolean login(Mobile31 mobile, String password) {
        if (account.getMobile().equals(mobile.value) && account.getPassword().equals(password)) {
            System.out.println("Login successful via mobile number!");
            return true;
        }
        System.out.println("Login failed: incorrect mobile or password.");
        return false;
    }

    boolean login(Email31 email, String password) {
        if (account.getEmail().equals(email.value) && account.getPassword().equals(password)) {
            System.out.println("Login successful via email!");
            return true;
        }
        System.out.println("Login failed: incorrect email or password.");
        return false;
    }
}

public class Main31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gmail Sign Up ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter mobile: ");
        String mobile = sc.nextLine();

        Gmail31 account = new Gmail31(username, email, password, mobile);
        User31 user = new User31(account);

        System.out.println("\nLogin using:\n1. Mobile\n2. Email");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        if (choice == 1) {
            System.out.print("Enter mobile: ");
            String m = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();
            user.login(new Mobile31(m), p);
        } else {
            System.out.print("Enter email: ");
            String e = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();
            user.login(new Email31(e), p);
        }

        sc.close();
    }
}
