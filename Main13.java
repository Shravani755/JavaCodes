import java.util.Scanner;

interface IM_13 {
    void m();
    default void dm() { System.out.println("IM_13 default dm()"); }
}

interface IN_13 {
    int n(int x);
    default int dn(int x) { return x - 1; }
}

abstract class AbsImpl13 implements IM_13, IN_13 {
    protected String tag;

    public AbsImpl13(String tag) {
        this.tag = tag;
    }

    public void m() { System.out.println("AbsImpl13.m() tag=" + tag); }
    public int n(int x) { return x * 10; }

    abstract void process();
}

class ConcreteA13 extends AbsImpl13 {
    public ConcreteA13(String tag) {
        super(tag);
    }

    void process() {
        System.out.println("ConcreteA13 processing with tag=" + tag);
    }
}

class Invoker13 {
    AbsImpl13 invoke(AbsImpl13 obj) {
        obj.process();
        obj.m();
        obj.dm();
        return obj;
    }
}

public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a tag: ");
        String tag = sc.nextLine();

        ConcreteA13 obj = new ConcreteA13(tag);
        Invoker13 invoker = new Invoker13();
        AbsImpl13 result = invoker.invoke(obj);

        System.out.print("Enter int for n(): ");
        int x = Integer.parseInt(sc.nextLine().trim());
        System.out.println("n() result: " + result.n(x));
        System.out.println("dn() result: " + result.dn(x));

        sc.close();
    }
}
