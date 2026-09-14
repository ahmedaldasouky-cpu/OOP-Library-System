import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        addMember();
                        break;
                    case 3:
                        borrowItem();
                        break;
                    case 4:
                        returnItem();
                        break;
                    case 5:
                        library.listCatalog();
                        break;
                    case 6:
                        library.printReport();
                        break;
                    case 7:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (LibraryException | IllegalArgumentException e) {
                System.out.println("Could not complete operation: "
                        + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("===== Library Lending System =====");
        System.out.println("1. Add Item");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Item");
        System.out.println("4. Return Item");
        System.out.println("5. List Catalog");
        System.out.println("6. Report");
        System.out.println("7. Exit");
    }

    private static void addItem() {
        System.out.println();
        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. DVD");

        int type = readInt("Choose item type: ");
        String title = readString("Title: ");

        switch (type) {
            case 1:
                String author = readString("Author: ");
                int pages = readInt("Pages: ");
                Book book = new Book(title, author, pages);
                library.addItem(book);
                System.out.println("Book added: " + book.getId());
                break;

            case 2:
                int issueNumber = readInt("Issue number: ");
                Magazine magazine = new Magazine(title, issueNumber);
                library.addItem(magazine);
                System.out.println("Magazine added: " + magazine.getId());
                break;

            case 3:
                int runtime = readInt("Runtime in minutes: ");
                DVD dvd = new DVD(title, runtime);
                library.addItem(dvd);
                System.out.println("DVD added: " + dvd.getId());
                break;

            default:
                System.out.println("Invalid item type.");
        }
    }

    private static void addMember() {
        String memberId = readString("Member ID: ");
        String name = readString("Member name: ");
        int maxAllowed = readInt("Maximum allowed: ");

        Member member = new Member(memberId, name, maxAllowed);
        library.addMember(member);

        System.out.println("Member added successfully.");
    }

    private static void borrowItem() throws LibraryException {
        String memberId = readString("Member ID: ");
        String itemId = readString("Item ID: ");
        library.borrowItem(memberId, itemId);
    }

    private static void returnItem() throws LibraryException {
        String memberId = readString("Member ID: ");
        String itemId = readString("Item ID: ");
        library.returnItem(memberId, itemId);
    }

    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
