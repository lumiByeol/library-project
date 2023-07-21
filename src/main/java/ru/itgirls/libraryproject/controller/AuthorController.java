package ru.itgirls.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDTO getAuthorByID(@PathVariable("id") Long id) {
        return authorService.getAuthorByID(id);
    }
}
