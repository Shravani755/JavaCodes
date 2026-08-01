import java.util.Scanner;

interface IA_10 {
    void a();
    default void da() { System.out.println("IA_10 default da()"); }
}

interface IB_10 {
    void b(int x);
    default int db(int x) { return x * 2; }
}

interface IC_10 {
    String c();
    default String dc(String s) { return s.toUpperCase(); }
}

abstract class Base10 {
    protected String info;

    public Base10(String info) {
        this.info = info;
    }

    abstract void baseAbstract();

    void baseDefined(int x) {
        System.out.println("baseDefined called with " + x + ", info=" + info);
    }
}

class Impl10 extends Base10 implements IA_10, IB_10, IC_10 {
    public Impl10(String info) {
        super(info);
    }

    void baseAbstract() { System.out.println("Impl10 baseAbstract, info=" + info); }
    public void a() { System.out.println("Impl10 a() called"); }
    public void b(int x) { System.out.println("Impl10 b(" + x + ") called"); }
    public String c() { return "Impl10 c() returns this string"; }
}

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter info string: ");
        String info = sc.nextLine();
        Impl10 obj = new Impl10(info);

        obj.baseAbstract();
        System.out.print("Enter int for baseDefined/b/db: ");
        int x = Integer.parseInt(sc.nextLine().trim());
        obj.baseDefined(x);

        obj.a();
        obj.da();
        obj.b(x);
        System.out.println("db result: " + obj.db(x));

        System.out.println("c(): " + obj.c());
        System.out.print("Enter string for dc: ");
        String s = sc.nextLine();
        System.out.println("dc result: " + obj.dc(s));

        sc.close();
    }
}
