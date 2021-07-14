package org.launchcode.modelbinding.controllers;

import org.launchcode.modelbinding.dataRepositories.BookRepository;
import org.launchcode.modelbinding.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    // GET /book -> returns a JSON List of all the books
    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", BookRepository.getAllBooks());
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
    public String addBook(@ModelAttribute Book newBook, Model model) {
        BookRepository.add(newBook);
        model.addAttribute("bookName", newBook.getTitle());
        return "bookAdded";
    }

    // GET /book/author/authorName -> returns a JSON List of all the books matching the path variable authorName
    @GetMapping(value = "/author/{authorName}")
    public String getBooksByAuthor(@PathVariable String authorName, Model model) {
        model.addAttribute("books", BookRepository.booksMatchingAuthor(authorName));
        return "filterBooks";
    }

    // GET /book/title/titleName -> Returns a JSON List of all the books matching the path variable titleName
    @GetMapping(value = "/title/{titleName}")
    public String getBooksByTitle(@PathVariable String titleName, Model model) {
        model.addAttribute("books", BookRepository.booksMatchingTitle(titleName));
        return "filterBooks";
    }

    @GetMapping(value = "/isbn/{isbn}")
    @ResponseBody
    public Book getBookByISBN(@PathVariable String isbn) {
        return BookRepository.bookMatchingISBN(isbn);
    }

}
