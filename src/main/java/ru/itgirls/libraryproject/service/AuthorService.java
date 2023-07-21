package ru.itgirls.libraryproject.service;

import ru.itgirls.libraryproject.dto.AuthorDTO;

public interface AuthorService {
    AuthorDTO getAuthorByID(Long id);
}
