package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public boolean issueBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println("Book issued successfully.");
                    return true;
                } else {
                    System.out.println("Book is already issued.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }

    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isIssued()) {
                    book.setIssued(false);
                    System.out.println("Book returned successfully.");
                    return true;
                } else {
                    System.out.println("This book was not issued.");
                    return false;
                }
            }
        }
        System.out.println("Book not found.");
        return false;
    }
}

