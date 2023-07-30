package ru.itgirls.libraryproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.dto.BookDTO;
import ru.itgirls.libraryproject.model.Book;
import ru.itgirls.libraryproject.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public BookDTO getBookByName1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertToDTO(book);
    }

    @Override
    public BookDTO getBookByName2(String name) {
        Book book = bookRepository.findBookByNameSQL(name).orElseThrow();
        return convertToDTO(book);
    }

    @Override
    public BookDTO getBookByName3(String name) {
        Specification<Book> bookSpecification = Specification.where(new Specification<>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        });

        Book book = bookRepository.findOne(bookSpecification).orElseThrow();
        return  convertToDTO(book);
    }

    private BookDTO convertToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre().getName())
                .authors(book.getAuthors()
                        .stream()
                        .map(author -> AuthorDTO.builder()
                                .name(author.getName())
                                .surname(author.getSurname())
                                .build())
                        .toList())
                .build();
    }
}
