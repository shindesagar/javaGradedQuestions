import java.util.Scanner;

public class iBooklist {
    static int invalid = -1;
    static int max_value = 100;
    static int[] bookid = new int[max_value];
    static String[] bookname = new String[max_value];
    static int[] bookPrice = new int[max_value];
    static int count = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("========== Library Management System ==========");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Update Book Quantity");
            System.out.println("4. Display Booklist");
            System.out.println("5. Sale");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addbook(scanner);
                    break;
                case 2:
                    removebook(scanner);
                 case 4:
                    displayBooklist();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    static void addbook(Scanner scanner) {
        System.out.println("enter the book id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter the book name: ");
        String Name = scanner.nextLine();

        System.out.println("enter the book price: ");
        int price = scanner.nextInt();
        // scanner.nextLine();
        bookid[count] = id;
        bookname[count] = Name;
        bookPrice[count] = price;
        count++;
        System.out.println("book added successfully");
    }

    static void displayBooklist() {
        if (count == 0) {
            System.out.println("Booklist is empty");
            return;
        }
        System.out.println("===========Booklist==============");
        System.out.println("ID\t Name\t Price\t");
        for (int i = 0; i < count; i++) {
            System.out.println(bookid[i] + "\t" + bookname[i] + "\t" +
            bookPrice[i]);
        }
    }

    static int findindex(int id) {
        for (int i = 0; i < count; i++) {
            if (bookid[i] == id) {
                return i;
            }

        }
        return invalid;
    }

    static void removebook(Scanner scanner) {
        System.out.println("enter the book id : ");
        int id = scanner.nextInt();
        int index = findindex(id);
        for (int i = index; i < count - 1; i++) {
            bookid[i] = bookid[i + 1];
            bookname[i] = bookname[i + 1];
            bookPrice[i] = bookPrice[i + 1];
        }
        count--;
        System.out.println("deleted successfully");
    }
}
