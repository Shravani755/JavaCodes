import java.util.Scanner;

interface P19 { void p(); default void dp() { System.out.println("P19 default dp()"); } }
interface Q19 { void q(); default void dq() { System.out.println("Q19 default dq()"); } }
interface R19 extends P19, Q19 {
    void r1();
    void r2();
}

class ImplA19 implements R19 {
    public void p() { System.out.println("ImplA19.p()"); }
    public void q() { System.out.println("ImplA19.q()"); }
    public void r1() { System.out.println("ImplA19.r1()"); }
    public void r2() { System.out.println("ImplA19.r2()"); }
}

class ImplB19 implements R19 {
    public void p() { System.out.println("ImplB19.p()"); }
    public void q() { System.out.println("ImplB19.q()"); }
    public void r1() { System.out.println("ImplB19.r1()"); }
    public void r2() { System.out.println("ImplB19.r2()"); }
}

class ImplC19 implements R19 {
    public void p() { System.out.println("ImplC19.p()"); }
    public void q() { System.out.println("ImplC19.q()"); }
    public void r1() { System.out.println("ImplC19.r1()"); }
    public void r2() { System.out.println("ImplC19.r2()"); }
}

class Test19 {
    void display(R19 obj) {
        obj.p();
        obj.dp();
        obj.q();
        obj.dq();
        obj.r1();
        obj.r2();
    }
}

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose implementation (A/B/C): ");
        String choice = sc.nextLine().trim().toUpperCase();

        R19 obj;
        switch (choice) {
            case "A": obj = new ImplA19(); break;
            case "B": obj = new ImplB19(); break;
            case "C": obj = new ImplC19(); break;
            default:
                System.out.println("Invalid choice, defaulting to A.");
                obj = new ImplA19();
        }

        new Test19().display(obj);

        sc.close();
    }
}
