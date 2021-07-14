package org.launchcode.modelbinding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    // this is the container holding all of the books
    public static ArrayList<HashMap<String, String>> books = new ArrayList<>();

    // GET /book -> returns a JSON List of all the books
    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", books);
        return "bookIndex";
    }

    // GET /book/new -> returns an HTML form
    @GetMapping(value = "/new")
    public String addBookForm() {
        return "newBookForm";
    }

    // POST /book/new -> takes in three query parameters: title, author, isbn and creates a new book out of these query parameters (these were the inputs of the HTML form in the GET handler)
    // POST /book/new?title=It,author=King,isbn=8093qhf
    @PostMapping(value = "/new")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn, Model model) {
        HashMap<String, String> newBook = new HashMap<>();
        newBook.put("title", title);
        newBook.put("author", author);
        newBook.put("ISBN", isbn);
        addBook(newBook);
        model.addAttribute("bookName", title);
        return "bookAdded";
    }

    // GET /book/author/authorName -> returns a JSON List of all the books matching the path variable authorName
    @GetMapping(value = "/author/{authorName}")
    public String getBooksByAuthor(@PathVariable String authorName, Model model) {
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("author").equals(authorName)) {
                matchingBooks.add(book);
            }
        }
        model.addAttribute("books", matchingBooks);
        return "filterBooks";
    }

    // GET /book/title/titleName -> Returns a JSON List of all the books matching the path variable titleName
    @GetMapping(value = "/title/{titleName}")
    public String getBooksByTitle(@PathVariable String titleName, Model model) {
        ArrayList<HashMap<String, String>> matchingBooks = new ArrayList<>();
        for(HashMap<String, String> book : books) {
            if(book.get("title").equals(titleName)) {
                matchingBooks.add(book);
            }
        }
        model.addAttribute("books", matchingBooks);
        return "filterBooks";
    }

    // a helper method that adds a new book to our static books property
    public static void addBook(HashMap<String, String> book) {
        books.add(book);
    }
}
