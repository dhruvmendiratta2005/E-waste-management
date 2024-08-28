import java.util.List;
import java.util.Scanner;

public class EWMSystem {
    private static UserService userService = new UserService();
    private static EWasteItemService eWasteItemService = new EWasteItemService();
    private static RequestService requestService = new RequestService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nE-Waste Management System");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage E-Waste Items");
            System.out.println("3. Manage Requests");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageUsers();
                    break;
                case 2:
                    manageEWasteItems();
                    break;
                case 3:
                    manageRequests();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageUsers() {
        System.out.println("\n1. Add User");
        System.out.println("2. View Users");
        System.out.println("3. Search User");
        System.out.println("4. Update User");
        System.out.println("5. Delete User");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();

                User user = new User(0, name, email, address);
                userService.addUser(user);
                break;
            case 2:
                List<User> users = userService.getAllUsers();
                for (User u : users) {
                    System.out.println(u);
                }
                break;
            case 3:
                System.out.print("Enter user ID: ");
                int userId = scanner.nextInt();
                User foundUser = userService.getUserById(userId);
                System.out.println(foundUser != null ? foundUser : "User not found.");
                break;
            case 4:
                System.out.print("Enter user ID: ");
                int updateUserId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();

                User updatedUser = new User(updateUserId, newName, newEmail, newAddress);
                userService.updateUser(updatedUser);
                break;
            case 5:
                System.out.print("Enter user ID: ");
                int deleteUserId = scanner.nextInt();
                userService.deleteUser(deleteUserId);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageEWasteItems() {
        System.out.println("\n1. Add E-Waste Item");
        System.out.println("2. View E-Waste Items");
        System.out.println("3. Search E-Waste Item");
        System.out.println("4. Update E-Waste Item");
        System.out.println("5. Delete E-Waste Item");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter item type: ");
                String type = scanner.nextLine();
                System.out.print("Enter item condition: ");
                String condition = scanner.nextLine();

                EWasteItem item = new EWasteItem(0, name, type, condition);
                eWasteItemService.addEWasteItem(item);
                break;
            case 2:
                List<EWasteItem> items = eWasteItemService.getAllEWasteItems();
                for (EWasteItem ewItem : items) {
                    System.out.println(ewItem);
                }
                break;
            case 3:
                System.out.print("Enter item ID: ");
                int itemId = scanner.nextInt();
                EWasteItem foundItem = eWasteItemService.getEWasteItemById(itemId);
                System.out.println(foundItem != null ? foundItem : "Item not found.");
                break;
            case 4:
                System.out.print("Enter item ID: ");
                int updateItemId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new name: ");
                String newItemName = scanner.nextLine();
                System.out.print("Enter new type: ");
                String newType = scanner.nextLine();
                System.out.print("Enter new condition: ");
                String newCondition = scanner.nextLine();

                EWasteItem updatedItem = new EWasteItem(updateItemId, newItemName, newType, newCondition);
                eWasteItemService.updateEWasteItem(updatedItem);
                break;
            case 5:
                System.out.print("Enter item ID: ");
                int deleteItemId = scanner.nextInt();
                eWasteItemService.deleteEWasteItem(deleteItemId);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageRequests() {
        System.out.println("\n1. Add Request");
        System.out.println("2. View Requests");
        System.out.println("3. Search Request");
        System.out.println("4. Update Request");
        System.out.println("5. Delete Request");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter user ID: ");
                int userId = scanner.nextInt();
                System.out.print("Enter item ID: ");
                int itemId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter request status: ");
                String status = scanner.nextLine();

                Request request = new Request(0, userId, itemId, status);
                requestService.addRequest(request);
                break;
            case 2:
                List<Request> requests = requestService.getAllRequests();
                for (Request req : requests) {
                    System.out.println(req);
                }
                break;
            case 3:
                System.out.print("Enter request ID: ");
                int requestId = scanner.nextInt();
                Request foundRequest = requestService.getRequestById(requestId);
                System.out.println(foundRequest != null ? foundRequest : "Request not found.");
                break;
            case 4:
                System.out.print("Enter request ID: ");
                int updateRequestId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new user ID: ");
                int newUserId = scanner.nextInt();
                System.out.print("Enter new item ID: ");
                int newItemId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new status: ");
                String newStatus = scanner.nextLine();

                Request updatedRequest = new Request(updateRequestId, newUserId, newItemId, newStatus);
                requestService.updateRequest(updatedRequest);
                break;
            case 5:
                System.out.print("Enter request ID: ");
                int deleteRequestId = scanner.nextInt();
                requestService.deleteRequest(deleteRequestId);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
