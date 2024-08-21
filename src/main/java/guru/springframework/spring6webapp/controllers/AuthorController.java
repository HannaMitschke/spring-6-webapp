/* Copyright Alcon 2023 */
package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.AuthorService;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(final AuthorService authorService) {
        super();
        this.authorService = authorService;
    }

    // model from MVC
    @RequestMapping("/authors") // when we go to 8080/books, spring will call this method
    public String getAuthors(final Model model) {
        model.addAttribute("authors", this.authorService.findAll());
        return "authors"; // spring boot is looking for a view called authors
    }
}
