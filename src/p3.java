import java.util.Scanner;

class Person {
    String name;
    int age;

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

class FamilyMember extends Person {
    String relation;

    public FamilyMember(String name, int age, String relation) {
        super(name, age);
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }
}

public class p3 {
    public static void main(String[] args) {
        // Creating arrays to store family members
        FamilyMember[] grandparents = new FamilyMember[2];
        FamilyMember[] parents = new FamilyMember[2];
        FamilyMember[] children = new FamilyMember[30];

        Scanner scanner = new Scanner(System.in);


        gatherUserInput(grandparents, "grandparents", scanner);
        gatherUserInput(parents, "parents", scanner);
        gatherChildrenInput(children, scanner);

        // Display family tree
        System.out.println("\nFamily Tree:");
        displayFamilyTree(grandparents, "Grandparent");
        displayFamilyTree(parents, "Parent");
        displayFamilyTree(children, "Child");

        scanner.close();
    }

    public static void gatherUserInput(FamilyMember[] family, String relation, Scanner scanner) {
        for (int i = 0; i < family.length; i++) {
            System.out.println("Enter details for " + relation + " " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            family[i] = new FamilyMember(name, age, relation);
        }
    }

    public static void gatherChildrenInput(FamilyMember[] children, Scanner scanner) {
        int i = 0;
        do {
            System.out.println("Enter details for Children of parents " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            children[i] = new FamilyMember(name, age, "Child");
            i++;
            if (i < children.length) {
                System.out.print("Do you want to add more children? (yes/no): ");
                String addMore = scanner.nextLine();
                if (!addMore.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } while (i < children.length);
    }


    // display all the input from the user
    public static void displayFamilyTree(FamilyMember[] family, String title) {
        System.out.println("\n" + title + "s:");
        for (FamilyMember member : family) {
            if (member != null) {
                System.out.println("Name: " + member.getName() + ", Age: " + member.getAge());
            }
        }
    }

}
