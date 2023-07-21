package ru.itgirls.libraryproject.service;

import ru.itgirls.libraryproject.dto.GenreDTO;

public interface GenreService {
    GenreDTO getGenreByID(Long id);
}
