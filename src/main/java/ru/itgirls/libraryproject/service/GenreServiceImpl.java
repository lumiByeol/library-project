package ru.itgirls.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.dto.BookDTO;
import ru.itgirls.libraryproject.dto.GenreDTO;
import ru.itgirls.libraryproject.model.Genre;
import ru.itgirls.libraryproject.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    @Override
    public GenreDTO getGenreByID(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDTO(genre);
    }

    private GenreDTO convertToDTO(Genre genre) {
        List<BookDTO> bookDTOList = genre.getBooks()
                .stream()
                .map(book -> BookDTO.builder()
                        .name(book.getName())
                        .id(book.getId())
                        .authors(book.getAuthors()
                                .stream()
                                .map(author -> AuthorDTO.builder()
                                        .name(author.getName())
                                        .surname(author.getSurname())
                                        .build())
                                .toList())
                        .build())
                .toList();

        return GenreDTO.builder()
                .books(bookDTOList)
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
