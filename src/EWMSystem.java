import java.util.Scanner;

public class EWMSystem {
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        User user = new User(id, name, email, address);
        userService.addUser(user);
        System.out.println("User added successfully!");
    }

    private static void viewAllUsers() {
        userService.getAllUsers().forEach(System.out::println);
    }
}
