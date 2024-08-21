/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.BookService;

@Controller
public class BookController {

    // get interface not implementation, means we can run multiple implementations into this using dep injection
    private final BookService bookService;

    // sets up book service to be injected
    public BookController(final BookService bookService) {
        super();
        this.bookService = bookService;
    }

    // model from MVC
    @RequestMapping("/books") // when we go to 8080/books, spring will call this method
    public String getBooks(final Model model) {
        // map and property key
        model.addAttribute("books", this.bookService.findAll());
        return "books"; // spring boot is looking for a view called books
    }

}
