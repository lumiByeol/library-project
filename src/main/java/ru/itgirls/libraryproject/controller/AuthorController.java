package ru.itgirls.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDTO getAuthorByID(@PathVariable("id") Long id) {
        return authorService.getAuthorByID(id);
    }

    @GetMapping("/author/v1")
    List<AuthorDTO> getAuthorByName1(@RequestParam("name") String name) {
        return authorService.getAuthorByName1(name);
    }

    @GetMapping("/author/v2")
    List<AuthorDTO> getAuthorByName2(@RequestParam("name") String name) {
        return authorService.getAuthorByName2(name);
    }

    @GetMapping("/author/v3")
    List<AuthorDTO> getAuthorByName3(@RequestParam("name") String name) {
        return authorService.getAuthorByName3(name);
    }
}