
// sharing common attributes and behaviors through superclass Employee
import java.util.Scanner;
class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Default implementation for calculating salary
    double calculateSalary() {
        return 0.0;
    }

    // FullTime class extends Employee, inheriting its attributes and methods
    class FullTime extends Employee {
        double salary;

        FullTime(int id, String name, double salary) {
            super(name, id); // Call superclass constructor
            this.salary = salary;
        }

        // Override calculateSalary() with specific implementation for full-time employees
        @Override
        double calculateSalary() {
            return salary;
        }
    }

    // PartTime class extends Employee, inheriting its attributes and methods
    class PartTime extends Employee {
        double hoursWork;
        double workRate;

        PartTime(int id, String name, double hoursWork, double workRate) {
            super(name, id); // Call superclass constructor
            this.hoursWork = hoursWork;
            this.workRate = workRate;
        }

        // Override calculateSalary() with specific implementation for part-time employees
        @Override
        double calculateSalary() {
            return hoursWork * workRate;
        }
    }

    // Constructor for Employee class
    public Employee() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for employee information
        System.out.println("---------------------------------------------------------");
        System.out.print("Employee ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Employee Name: ");
        this.name = scanner.nextLine();

        // Prompt user to select employee type (FullTime or PartTime)
        System.out.println("Select [1]Full Time Employee or [2]Part Time Employee");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Based on user selection, create corresponding FullTime or PartTime object
        if (option == 1) {
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            // Create FullTime object and display salary
            FullTime fullTimeEmployee = new FullTime(id, name, salary);
            System.out.println("Full-time employee salary: ₱" + fullTimeEmployee.calculateSalary());
        } else if (option == 2) {
            System.out.print("Enter Hours Worked: ");
            double hoursWork = scanner.nextDouble();
            System.out.print("Enter Hourly Rate: ");
            double workRate = scanner.nextDouble();
            // Create PartTime object and display salary
            PartTime partTimeEmployee = new PartTime(id, name, hoursWork, workRate);
            System.out.println("Part-time employee salary: ₱" + partTimeEmployee.calculateSalary());
        }
    }
}

// Main class to execute the program
public class Payroll {
    public static void main(String[] args) {
        // Create an instance of Employee to start the payroll system
        Employee emp = new Employee();
    }
}
