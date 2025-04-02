package edubridge;
import java.util.*;

class Student { private String id; private String name; private List<String> courses; private double balance;

public Student(String id, String name) {
    this.id = id;
    this.name = name;
    this.courses = new ArrayList<>();
    this.balance = 0.0;
}

public String getId() { return id; }
public String getName() { return name; }
public List<String> getCourses() { return courses; }
public double getBalance() { return balance; }

public void enrollCourse(String course) {
    courses.add(course);
    System.out.println(name + " enrolled in " + course);
}

public void payFees(double amount) {
    balance -= amount;
    System.out.println(name + " paid " + amount);
}

public void viewStatus() {
    System.out.println("ID: " + id + " | Name: " + name);
    System.out.println("Courses: " + courses);
    System.out.println("Balance: " + balance);
}

}

public class StudentManagementSystem {
	 private static Map<String, Student> students = new HashMap<>(); private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	    while (true) {
	        System.out.println("1. Add Student\n2. Enroll in Course\n3. Pay Fees\n4. View Status\n5. Exit");
	        System.out.print("Choose an option: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine();

	        switch (choice) {
	            case 1:
	                addStudent();
	                break;
	            case 2:
	                enrollStudent();
	                break;
	            case 3:
	                payFees();
	                break;
	            case 4:
	                viewStatus();
	                break;
	            case 5:
	                System.out.println("Exiting...");
	                return;
	            default:
	                System.out.println("Invalid choice. Try again.");
	        }
	    }
	}

	private static void addStudent() {
	    System.out.print("Enter Student ID: ");
	    String id = scanner.nextLine();
	    System.out.print("Enter Student Name: ");
	    String name = scanner.nextLine();
	    students.put(id, new Student(id, name));
	    System.out.println("Student added successfully.");
	}

	private static void enrollStudent() {
	    System.out.print("Enter Student ID: ");
	    String id = scanner.nextLine();
	    Student student = students.get(id);
	    if (student != null) {
	        System.out.print("Enter Course Name: ");
	        String course = scanner.nextLine();
	        student.enrollCourse(course);
	    } else {
	        System.out.println("Student not found.");
	    }
	}

	private static void payFees() {
	    System.out.print("Enter Student ID: ");
	    String id = scanner.nextLine();
	    Student student = students.get(id);
	    if (student != null) {
	        System.out.print("Enter Amount: ");
	        double amount = scanner.nextDouble();
	        scanner.nextLine();
	        student.payFees(amount);
	    } else {
	        System.out.println("Student not found.");
	    }
	}

	private static void viewStatus() {
	    System.out.print("Enter Student ID: ");
	    String id = scanner.nextLine();
	    Student student = students.get(id);
	    if (student != null) {
	        student.viewStatus();
	    } else {
	        System.out.println("Student not found.");
	    }
	}

	}


