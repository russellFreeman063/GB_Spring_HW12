package ru.gb.homework12.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.homework12.model.Book;
import ru.gb.homework12.service.BookStoreService;
import ru.gb.homework12.service.FileGateway;


@Controller
@AllArgsConstructor
public class BookStoreController {

    private final BookStoreService service;

    private final FileGateway fileGateway;

    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }

    @PostMapping("/books")
    public String addBook(Model model, Book book) {
        service.createBook(book);
        fileGateway.writeToFile(book.getAuthor(), book.toString());
        model.addAttribute("books", service.getAllBooks());
        return "books";
    }


}
