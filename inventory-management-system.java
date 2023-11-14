import java.util.Scanner;

public class InventoryManagementSystem {

    // Define arrays to store product information
    static int[] productIDs = {
        101, 
        102, 
        103, 
        104, 
        105, 
        106, 
        107, 
        108, 
        109, 
        110
    };
    static String[] productNames = {
        "Mobile", 
        "Laptop", 
        "Tablet", 
        "Portable HDD", 
        "Bluetooth Headphone",
         "Smart-watch", 
         "Digital Camera", 
         "Portable Power bank", 
         "Printer", 
         "Wireless Router"
    };
    static int[] availableCounts = {
        10, 
        20, 
        15, 
        30, 
        25, 
        25, 
        18, 
        40, 
        12, 
        22
    };
    static String[] specifications = {
            "Android and iOS compatible", 
            "High-performance laptop", 
            "10-inch display, 64GB storage",
            "1TB storage, USB 3.0", 
            "Wireless, noise-canceling", 
            "Water-resistant, fitness tracking",
            "20MP, 4K video recording", 
            "10000mAh capacity", 
            "Wireless printing", 
            "Dual-band, high-speed"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the SmartPoint Electronics Store");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        char choice;
        do {
            displayMenu();
            System.out.print("Please choose an option from the above menu: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    checkProductCount(scanner);
                    break;
                case 3:
                    viewProductDetails(scanner);
                    break;
                case 4:
                    editProductDetails(scanner);
                    break;
                case 5:
                    updateInventory(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }

            System.out.print("\nEnter \"Y\" to return to the main menu or \"N\" to Exit: ");
            choice = scanner.nextLine().toUpperCase().charAt(0);
        } while (choice == 'Y');

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("View the complete list of our products\n" +
                "Check the available count for a specific product\n" +
                "View the specifications and details of a specific product\n" +
                "Modify the details of a specific product\n" +
                "Update the inventory for a specific product\n" +
                "Exit");
    }

    private static void displayProductList() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("List of all Products\n");
        System.out.printf("%-15s%-25s\n", "Product ID", "Product Name");

        for (int i = 0; i < productIDs.length; i++) {
            System.out.printf("%-15d%-25s\n", productIDs[i], productNames[i]);
        }
    }

    private static void checkProductCount(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();

        int index = findProductIndex(productId);
        if (index != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(productIDs[index] + productNames[index]);
            System.out.println("Total available count: " + availableCounts[index]);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewProductDetails(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();

        int index = findProductIndex(productId);
        if (index != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(productIDs[index] + productNames[index]);
            System.out.println("Total available count: " + availableCounts[index]);
            System.out.println("Specifications: " + specifications[index]);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void editProductDetails(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();

        int index = findProductIndex(productId);
        if (index != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(productIDs[index] + productNames[index]);
            System.out.println("Total available count: " + availableCounts[index]);
            System.out.println("Specifications: " + specifications[index]);

            System.out.println("\nEnter new details for the product:");

            System.out.print("New Specifications: ");
            specifications[index] = scanner.next();

            System.out.print("New Cost: ");
            // Assuming there is a cost associated with each product, you can add a cost array and update it here if needed.

            System.out.print("New Available Count: ");
            availableCounts[index] = scanner.nextInt();

            System.out.println("Details updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void updateInventory(Scanner scanner) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Product ID: ");
        int productId = scanner.nextInt();

        int index = findProductIndex(productId);
        if (index != -1) {
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println(productIDs[index] + productNames[index]);
            System.out.println("Current available inventory for " + productNames[index] + ": " + availableCounts[index]);

            System.out.println("\nAdd inventory\nSubtract inventory");
            System.out.print("Please choose an option from the above menu: ");
            int inventoryOption = scanner.nextInt();

            if (inventoryOption == 1) {
                System.out.print("Please enter the count to be added: ");
                int countToAdd = scanner.nextInt();
                availableCounts[index] += countToAdd;
            } else if (inventoryOption == 2) {
                System.out.print("Please enter the count to be subtracted: ");
                int countToSubtract = scanner.nextInt();
                if (countToSubtract <= availableCounts[index]) {
                    availableCounts[index] -= countToSubtract;
                } else {
                    System.out.println("Cannot subtract more than available inventory.");
                }
            } else {
                System.out.println("Invalid option.");
            }

            System.out.println("Total available count: " + availableCounts[index]);
            System.out.println("Inventory updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static int findProductIndex(int productId) {
        for (int i = 0; i < productIDs.length; i++) {
            if (productIDs[i] == productId) {
                return i;
            }
        }
        return -1;
    }
}
