package org.launchcode.modelbinding.dataRepositories;

import org.launchcode.modelbinding.models.Book;

import java.util.ArrayList;

public class BookRepository {
    public static ArrayList<Book> books = new ArrayList<>();

    // add method
    public static void add(Book newBook) {
        books.add(newBook);
    }

}
