import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class UserAccount {
    protected String username;
    protected String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean authenticate(String username, String password);
}

abstract class TaskManager {
    protected List<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public abstract void addTask(String task);
    public abstract void removeTask(int index);
    public abstract void displayTasks();
}

class BasicUserAccount extends UserAccount {

    public BasicUserAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class TaskList extends TaskManager {

    @Override
    public void addTask(String task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    @Override
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}

class PriorityTaskList extends TaskManager {
    @Override
    public void addTask(String task) {
        tasks.add(0, task);
    }

    @Override
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    @Override
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}


public class todo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List program!");

        //
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user
        UserAccount userAccount = new BasicUserAccount("jesreel", "123");
        if (userAccount.authenticate(username, password)) {

            runToDoList();
        } else {
            System.out.println("Authentication failed. Exiting program.");
        }

        scanner.close();
    }

    private static void runToDoList() {
        Scanner scanner = new Scanner(System.in);
        TaskManager regularTaskList = new TaskList();
        TaskManager priorityTaskList = new PriorityTaskList();

        System.out.println("To-Do List Program");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add task to regular list");
            System.out.println("2. Add task to priority list");
            System.out.println("3. Remove task from regular list");
            System.out.println("4. Remove task from priority list");
            System.out.println("5. Display regular list tasks");
            System.out.println("6. Display priority list tasks");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter task for regular list:");
                    regularTaskList.addTask(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter task for priority list:");
                    priorityTaskList.addTask(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Enter index of task to remove from regular list:");
                    regularTaskList.removeTask(scanner.nextInt() - 1);
                    break;
                case 4:
                    System.out.println("Enter index of task to remove from priority list:");
                    priorityTaskList.removeTask(scanner.nextInt() - 1);
                    break;
                case 5:
                    regularTaskList.displayTasks();
                    break;
                case 6:
                    priorityTaskList.displayTasks();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}