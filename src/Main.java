import model.Book;
import model.Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Welcome to Library Management System!");

        while (!exit) {
            printMenu();
            int choice = getIntInput("Choose an option:");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> searchBooksByTitle();
                case 4 -> searchBooksByAuthor();
                case 5 -> issueBook();
                case 6 -> returnBook();
                case 7 -> {
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Search Book by Title");
        System.out.println("4. Search Book by Author");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Book book = new Book(isbn, title, author);
        library.addBook(book);
    }

    private static void listBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void searchBooksByTitle() {
        System.out.print("Enter title keyword to search: ");
        String title = scanner.nextLine();

        List<Book> results = library.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("No books found with that title.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void searchBooksByAuthor() {
        System.out.print("Enter author keyword to search: ");
        String author = scanner.nextLine();

        List<Book> results = library.searchByAuthor(author);
        if (results.isEmpty()) {
            System.out.println("No books found with that author.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void issueBook() {
        System.out.print("Enter ISBN of book to issue: ");
        String isbn = scanner.nextLine();
        library.issueBook(isbn);
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of book to return: ");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return num;
    }
}
