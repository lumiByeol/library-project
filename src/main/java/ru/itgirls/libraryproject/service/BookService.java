package ru.itgirls.libraryproject.service;

import ru.itgirls.libraryproject.dto.BookDTO;

public interface BookService {
    BookDTO getBookByName1(String name);

    BookDTO getBookByName2(String name);

    BookDTO getBookByName3(String name);
}
