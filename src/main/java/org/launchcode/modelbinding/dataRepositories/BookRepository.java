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

}
