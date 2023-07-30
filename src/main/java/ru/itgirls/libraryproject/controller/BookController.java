package ru.itgirls.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.libraryproject.dto.BookDTO;
import ru.itgirls.libraryproject.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book/v1")
    BookDTO getBookByName1(@RequestParam("name") String name) {
        return bookService.getBookByName1(name);
    }

    @GetMapping("/book/v2")
    BookDTO getBookByName2(@RequestParam("name") String name) {
        return bookService.getBookByName2(name);
    }

    @GetMapping("/book/v3")
    BookDTO getBookByName3(@RequestParam("name") String name) {
        return bookService.getBookByName3(name);
    }
}
