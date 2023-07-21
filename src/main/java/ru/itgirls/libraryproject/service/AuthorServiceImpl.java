package ru.itgirls.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.dto.BookDTO;
import ru.itgirls.libraryproject.model.Author;
import ru.itgirls.libraryproject.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public AuthorDTO getAuthorByID(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return convertToDTO(author);
    }

    private AuthorDTO convertToDTO(Author author) {
        List<BookDTO> bookDTOList = author.getBooks()
                .stream()
                .map(book -> BookDTO.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build())
                .toList();

        return AuthorDTO.builder()
                .books(bookDTOList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }
}
