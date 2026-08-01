import java.lang.reflect.Constructor;
import java.util.Scanner;

class Secret11 {
    int code; // instance variable

    private Secret11() { // default constructor with private access
        code = 0;
    }

    void show() { // non-static method
        System.out.println("Secret11 code value: " + code);
    }
}

public class Main11 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Private constructor -> instantiate via reflection from the separate Test class
        Constructor<Secret11> con = Secret11.class.getDeclaredConstructor();
        con.setAccessible(true);
        Secret11 obj = con.newInstance();

        System.out.print("Enter a value for code: ");
        obj.code = Integer.parseInt(sc.nextLine().trim());

        obj.show();

        sc.close();
    }
}
