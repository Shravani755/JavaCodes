import java.util.Scanner;

interface IAlpha26 { void alpha(); default void dAlpha() { System.out.println("IAlpha26 default dAlpha()"); } }
interface IBeta26 { void beta(); default void dBeta() { System.out.println("IBeta26 default dBeta()"); } }

abstract class AbsOne26 {
    public AbsOne26(String tag) {
        System.out.println("AbsOne26 constructed with tag=" + tag);
    }
    abstract void methodOne();
}

abstract class AbsTwo26 extends AbsOne26 {
    public AbsTwo26(String tag) {
        super(tag);
    }
    abstract void methodTwo();
}

class TestImpl26 extends AbsTwo26 implements IAlpha26, IBeta26 {
    public TestImpl26(String tag) {
        super(tag);
    }
    void methodOne() { System.out.println("TestImpl26.methodOne()"); }
    void methodTwo() { System.out.println("TestImpl26.methodTwo()"); }
    public void alpha() { System.out.println("TestImpl26.alpha()"); }
    public void beta() { System.out.println("TestImpl26.beta()"); }
}

public class Main26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a tag: ");
        String tag = sc.nextLine();

        TestImpl26 obj = new TestImpl26(tag);
        obj.methodOne();
        obj.methodTwo();
        obj.alpha();
        obj.dAlpha();
        obj.beta();
        obj.dBeta();

        sc.close();
    }
}
