import java.util.Scanner;

interface IX_12 {
    void x();
    default void dx() { System.out.println("IX_12 default dx()"); }
}

interface IY_12 {
    int y(int v);
    default int dy(int v) { return v + 100; }
}

abstract class AbsBase12 {
    protected IX_12 ix;

    public AbsBase12(IX_12 ix) {
        this.ix = ix;
    }

    abstract void process();
}

class ConcreteImpl12 extends AbsBase12 {
    public ConcreteImpl12(IX_12 ix) {
        super(ix);
    }

    void process() {
        ix.x();
        ix.dx();
    }
}

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a message for IX_12.x(): ");
        String msg = sc.nextLine();

        IX_12 ixObj = new IX_12() {
            public void x() {
                System.out.println("IX_12.x() -> " + msg);
            }
        };

        ConcreteImpl12 obj = new ConcreteImpl12(ixObj);
        obj.process();

        IY_12 iyObj = new IY_12() {
            public int y(int v) {
                return v * v;
            }
        };
        System.out.print("Enter an int for IY_12: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        System.out.println("y() result: " + iyObj.y(v));
        System.out.println("dy() result: " + iyObj.dy(v));

        sc.close();
    }
}
