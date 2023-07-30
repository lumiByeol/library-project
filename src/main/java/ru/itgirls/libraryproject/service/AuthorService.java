package ru.itgirls.libraryproject.service;

import ru.itgirls.libraryproject.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO getAuthorByID(Long id);

    List<AuthorDTO> getAuthorByName1(String name);

    List<AuthorDTO> getAuthorByName2(String name);

    List<AuthorDTO> getAuthorByName3(String name);
}
