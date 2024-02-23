/*
import java.util.Scanner;

// Class representing a person
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Class representing a parent which inherits from Person
class Parent extends Person {
    protected int numChildren;

    public Parent(String name, int age, int numChildren) {
        super(name, age);
        this.numChildren = numChildren;
    }

    public int getNumChildren() {
        return numChildren;
    }
}

// Class representing a child which inherits from Person
class Child extends Person {
    public Child(String name, int age) {
        super(name, age);
    }
}

// Class representing the family tree
class FamilyTree {
    private Grandparent[] grandparents = new Grandparent[2];
    private Parent[] parents = new Parent[2];
    private Child[] children;

    // Constructor to initialize grandparents
    public FamilyTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter names of grandparents:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Grandparent " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            grandparents[i] = new Grandparent(name);
        }
    }

    // Method to input parents information
    public void inputParents() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter details for parent " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Number of children: ");
            int numChildren = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            parents[i] = new Parent(name, age, numChildren);
        }
    }

    // Method to input children information
    public void inputChildren() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of children for the parents: ");
        int numChildren = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        children = new Child[numChildren];
        for (int i = 0; i < numChildren; i++) {
            System.out.println("Enter details for child " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            children[i] = new Child(name, age);
        }
    }

    // Method to display the family tree
    public void displayFamilyTree() {
        System.out.println("\nFamily Tree:");
        System.out.println("Grandparents:");
        for (Grandparent grandparent : grandparents) {
            System.out.println("Name: " + grandparent.getName());
        }
        System.out.println("\nParents:");
        for (Parent parent : parents) {
            System.out.println("Name: " + parent.getName() + ", Age: " + parent.getAge() + ", Number of children: " + parent.getNumChildren());
        }
        System.out.println("\nChildren:");
        for (Child child : children) {
            System.out.println("Name: " + child.getName() + ", Age: " + child.getAge());
        }
    }
}

// Class representing a grandparent which inherits from Person
class Grandparent extends Person {
    public Grandparent(String name) {
        super(name, 0); // Grandparents' age not specified
    }
}

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        familyTree.inputParents();
        familyTree.inputChildren();
        familyTree.displayFamilyTree();
    }
}
*/
