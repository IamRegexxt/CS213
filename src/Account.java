import java.util.Scanner;

class Student {
    String studentName;
    double balance;

    public Student(String studentName, double initialBalance) {
        this.studentName = studentName;
        this.balance = initialBalance;
    }

    public void deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Deducted " + amount + " From " + studentName + "'s Account");
        } else {
            System.out.println("Insufficient balance in " + studentName + "'s account");
        }
    }

    public void display() {
        System.out.println(studentName + "'s Current Balance is " + balance);
    }
}

class Cashier {
    double totalTuition;
    String studentName;
    double miscellaneousFees;
    double otherSchoolFees;
    double laboratoryFees;

    public Cashier(double totalTuition) {
        this.totalTuition = totalTuition;
    }

    public void inputStudentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        studentName = scanner.nextLine();
    }

    public void inputFees() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Miscellaneous Fees: ");
        miscellaneousFees = scanner.nextDouble();

        System.out.print("Enter Other School Fees: ");
        otherSchoolFees = scanner.nextDouble();

        System.out.print("Enter Laboratory Fees: ");
        laboratoryFees = scanner.nextDouble();

        scanner.close();
    }

    public double calculateGrandTotal() {
        return totalTuition + miscellaneousFees + otherSchoolFees + laboratoryFees;
    }

    public void displayGrandTotal() {
        System.out.println("Grand Total Fees for " + studentName + ": " + calculateGrandTotal());
    }
}

public class Account {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Select an option:");
        System.out.println("1. Student Account");
        System.out.println("2. Cashier");

        int option = scanner.nextInt();

        if (option == 1) {
            // Student Account
            System.out.println("Enter Student Name: ");
            String studentName = scanner.next();
            System.out.println("Enter Current Balance: ");
            double currentBalance = scanner.nextDouble();

            Student studentAccount = new Student(studentName, currentBalance);

            while (true) {
                System.out.println("Enter amount to pay (or 0 to end transaction): ");
                double pay = scanner.nextDouble();
                if (pay == 0) {
                    break;
                }
                studentAccount.deduct(pay);
            }

            studentAccount.display();
        } else if (option == 2) {
            // Cashier Feature
            Cashier cashier = new Cashier(0); //
            cashier.inputStudentName();
            System.out.println("Enter total tuition: ");
            double totalTuition = scanner.nextDouble();
            cashier.totalTuition = totalTuition;
            cashier.inputFees();
            cashier.displayGrandTotal();
        } else {
            System.out.println("Invalid option selected.");
        }
    }
}
