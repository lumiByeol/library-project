package ru.itgirls.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.libraryproject.dto.GenreDTO;
import ru.itgirls.libraryproject.service.GenreService;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genre/{id}")
    GenreDTO getGenreByID(@PathVariable("id") Long id) {
        return genreService.getGenreByID(id);
    }
}
