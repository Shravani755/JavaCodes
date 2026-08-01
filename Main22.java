import java.lang.reflect.Constructor;
import java.util.Scanner;

class Secret22 {
    int code; // instance variable

    private Secret22() { // default constructor with private access
        code = 0;
    }

    void show() { // non-static method
        System.out.println("Secret22 code value: " + code);
    }
}

public class Main22 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Constructor<Secret22> con = Secret22.class.getDeclaredConstructor();
        con.setAccessible(true);
        Secret22 obj = con.newInstance();

        System.out.print("Enter a value for code: ");
        obj.code = Integer.parseInt(sc.nextLine().trim());

        obj.show();

        sc.close();
    }
}
