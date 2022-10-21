package com.example.web.controllers;

import com.example.web.entities.Book;
import com.example.web.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Controller
public class BooksController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/")
    public String start() {
        return "redirect:/shop?page=1";
    }

    @GetMapping("/shop")
    public String mainPage(@RequestParam Integer page, Map<String, Object> model) {
        Pageable paginator = PageRequest.of(page-1, 5);

        Iterable<Book> books = bookRepo.findAll(paginator);

        Iterable<Book> booksAll = bookRepo.findAll();
        List<Book> booksList = new ArrayList<Book>();
        booksAll.forEach(booksList::add);
        int count = booksList.size();
        int ost = count % 5;

        if (ost > 0)
            count = count / 5 + 1;
        else
            count = count / 5;

        List<Integer> pages = new ArrayList<>();
        for(int i = 0; i < count; i++)
            pages.add(i+1);

        model.put("books", books);
        model.put("pages", pages);
        model.put("number", page);
        model.put("count", count);

        return "main";
    }

    @GetMapping("/create")
    public String addBookForm() {
        return "create";
    }

    @PostMapping("/create")
    public String addBook(@RequestParam String name,
                      @RequestParam String author,
                      @RequestParam Integer price) {
        Book book = new Book(name, author, price);
        bookRepo.save(book);

        return "redirect:/shop?page=1";
    }

    @GetMapping("/edit")
    public String editBookForm(@RequestParam Integer id, Map<String, Object> model) {
        Optional<Book> book = bookRepo.findById(id);

        if (book.isPresent()) {
            model.put("book", book.get());
            return "edit";
        }
        return "redirect:/shop?page=1";
    }

    @PostMapping("/edit")
    public String editBook(@RequestParam Integer id,
                           @RequestParam String name,
                           @RequestParam String author,
                           @RequestParam Integer price) {
        Book book = bookRepo.findById(id).get();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        bookRepo.save(book);

        return "redirect:/shop?page=1";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam Integer id) {
        if (bookRepo.findById(id).isPresent())
            bookRepo.deleteById(id);

        return "redirect:/shop?page=1";
    }
}
