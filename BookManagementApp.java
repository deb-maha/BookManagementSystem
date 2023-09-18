package demo;
import java.util.*;
public class BookManagementApp {
    private static Map<Integer, Book> bookDatabase = new HashMap<>();
    private static int nextBookId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Retrieve book by ID");
            System.out.println("3. Update book details");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    retrieveBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        try {
            System.out.print("Enter Book Name: ");
            String bookName = scanner.nextLine();

            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();

            Book newBook = new Book(bookName, nextBookId, isbn);
            bookDatabase.put(nextBookId, newBook);

            System.out.println("Book added successfully with ID: " + nextBookId);
            nextBookId++;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void retrieveBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        Book book = bookDatabase.get(bookId);

        if (book != null) {
            System.out.println("Book Details:\n" + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book book = bookDatabase.get(bookId);

        if (book != null) {
            try {
                System.out.print("Enter new Book Name: ");
                String newBookName = scanner.nextLine();

                System.out.print("Enter new ISBN: ");
                String newIsbn = scanner.nextLine();

                book = new Book(newBookName, bookId, newIsbn);
                bookDatabase.put(bookId, book);

                System.out.println("Book updated successfully.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter Book ID to delete: ");
        int bookId = scanner.nextInt();

        Book removedBook = bookDatabase.remove(bookId);

        if (removedBook != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}