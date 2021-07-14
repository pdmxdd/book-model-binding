package org.launchcode.modelbinding.dataRepositories;

import org.launchcode.modelbinding.models.Book;

import java.util.ArrayList;

public class BookRepository {
    private static ArrayList<Book> books = new ArrayList<>();

    // get All books
    public static ArrayList<Book> getAllBooks() {
        return books;
    }

    // add method
    public static void add(Book newBook) {
        books.add(newBook);
    }

    // return all books that match a specific author
    public static ArrayList<Book> booksMatchingAuthor(String authorName) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getAuthor().equals(authorName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    // return all books that match a specific title
    public static ArrayList<Book> booksMatchingTitle(String titleName) {
        ArrayList<Book> matchingBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.getTitle().equals(titleName)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

}
