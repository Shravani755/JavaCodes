import java.util.Scanner;

interface IX_23 {
    void x();
    default void dx() { System.out.println("IX_23 default dx()"); }
}

interface IY_23 {
    int y(int v);
    default int dy(int v) { return v + 200; }
}

abstract class AbsBase23 {
    protected IX_23 ix;

    public AbsBase23(IX_23 ix) {
        this.ix = ix;
    }

    abstract void process();
}

class ConcreteImpl23 extends AbsBase23 {
    public ConcreteImpl23(IX_23 ix) {
        super(ix);
    }

    void process() {
        ix.x();
        ix.dx();
    }
}

public class Main23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message for IX_23.x(): ");
        String msg = sc.nextLine();

        IX_23 ixObj = new IX_23() {
            public void x() {
                System.out.println("IX_23.x() -> " + msg);
            }
        };

        ConcreteImpl23 obj = new ConcreteImpl23(ixObj);
        obj.process();

        IY_23 iyObj = new IY_23() {
            public int y(int v) {
                return v * v;
            }
        };
        System.out.print("Enter an int for IY_23: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        System.out.println("y() result: " + iyObj.y(v));
        System.out.println("dy() result: " + iyObj.dy(v));

        sc.close();
    }
}
