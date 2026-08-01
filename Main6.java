import java.util.Scanner;

abstract class Student6 {
    protected int stdId;
    protected String stdName;
    protected double stdMarks;

    public Student6(int stdId, String stdName, double stdMarks) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdMarks = stdMarks;
    }

    abstract void display();
}

class StudentDetails6 extends Student6 {
    public StudentDetails6(int stdId, String stdName, double stdMarks) {
        super(stdId, stdName, stdMarks);
    }

    void enterId(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int Std_id = Integer.parseInt(sc.nextLine().trim());
        this.stdId = Std_id;
    }

    void enterName(Scanner sc) {
        System.out.print("Enter Student Name: ");
        String Std_name = sc.nextLine().trim();
        this.stdName = Std_name;
    }

    void enterMarks(Scanner sc) {
        System.out.print("Enter Student Marks: ");
        double Std_marks = Double.parseDouble(sc.nextLine().trim());
        this.stdMarks = Std_marks;
    }

    void display() {
        System.out.println("ID: " + stdId + " | Name: " + stdName + " | Marks: " + stdMarks);
    }
}

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDetails6[] students = new StudentDetails6[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");
            StudentDetails6 sd = new StudentDetails6(0, "", 0.0);
            sd.enterId(sc);
            sd.enterName(sc);
            sd.enterMarks(sc);
            students[i] = sd;
        }

        System.out.print("\nEnter Student ID to display details: ");
        int searchId = Integer.parseInt(sc.nextLine().trim());

        boolean found = false;
        for (StudentDetails6 sd : students) {
            if (sd.stdId == searchId) {
                sd.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }

        sc.close();
    }
}
