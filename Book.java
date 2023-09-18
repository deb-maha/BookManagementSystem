package demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String bookName;
    private int bookId;
    private String isbn;

    public Book(String bookName, int bookId, String isbn) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + "\nBook Name: " + bookName + "\nISBN: " + isbn;
    }
}