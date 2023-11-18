import java.util.Scanner;

public class iinventory {
    static int invalid = -1;
    static int max_value = 100;
    static int[] productid = new int[max_value];
    static String[] productname = new String[max_value];
    static int[] productPrice = new int[max_value];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("========== Inventory Management System ==========");
            System.out.println("1. Add a Product");
            System.out.println("2. Remove a Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Display Inventory");
            System.out.println("5. Sale");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    removeProduct(scanner);
                    // break;
                    // case 3:
                    // updateProductQuantity(scanner);
                    // break;
                case 4:
                    displayInventory();
                    break;
                // case 5:
                // makeSale(scanner);
                // break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    static void addProduct(Scanner scanner) {
        System.out.println("enter the product id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter the product name: ");
        String Name = scanner.nextLine();

        System.out.println("enter the product price: ");
        int price = scanner.nextInt();
        // scanner.nextLine();
        productid[count] = id;
        productname[count] = Name;
        productPrice[count] = price;
        count++;
        System.out.println("product added successfully");
    }

    static void displayInventory() {
        if (count == 0) {
            System.out.println("inventory is empty");
            return;
        }
        System.out.println("===========Inventory==============");
        System.out.println("ID\t Name\t Price\t");
        for (int i = 0; i < count; i++) {
            // System.out.println(productid[i] + "\t" + productname[i] + "\t" +
            // productPrice[i]);
            System.out.printf("%d\t%7s%d%n", productid[i], productname[i], productPrice[i]);
        }
    }

    static int findindex(int id) {
        for (int i = 0; i < count; i++) {
            if (productid[i] == id) {
                return i;
            }

        }
        return invalid;
    }

    static void removeProduct(Scanner scanner) {
        System.out.println("enter the product id : ");
        int id = scanner.nextInt();
        int index = findindex(id);
        for (int i = index; i < count - 1; i++) {
            productid[i] = productid[i + 1];
            productname[i] = productname[i + 1];
            productPrice[i] = productPrice[i + 1];
        }
        count--;
        System.out.println("deleted successfully");
    }
}
