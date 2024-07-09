import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();
    private static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*********************");
            System.out.println("Library Management System");
            System.out.println("*********************");
            System.out.println("1. User Login");
            System.out.println("2. Administrator Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userManager.getUser(username, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getName() + "!");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void adminLogin() {
        System.out.print("Enter administrator username: ");
        String username = scanner.nextLine();
        System.out.print("Enter administrator password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Welcome, Administrator!");
            adminMenu();
        } else {
            System.out.println("Invalid administrator credentials.");
        }
    }

    private static void userMenu(User user) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Borrowed Books");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    borrowBook(user);
                    break;
                case 3:
                    returnBook(user);
                    break;
                case 4:
                    viewBorrowedBooks(user);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View Users");
            System.out.println("4. Add User");
            System.out.println("5. Remove User");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    viewUsers();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    removeUser();
                    break;
                case 6:
                    System.out.println("

