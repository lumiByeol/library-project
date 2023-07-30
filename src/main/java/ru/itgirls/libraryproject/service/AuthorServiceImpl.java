package ru.itgirls.libraryproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirls.libraryproject.dto.AuthorDTO;
import ru.itgirls.libraryproject.dto.BookDTO;
import ru.itgirls.libraryproject.model.Author;
import ru.itgirls.libraryproject.repository.AuthorRepository;

import java.util.ArrayList;
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

    @SneakyThrows
    @Override
    public List<AuthorDTO> getAuthorByName1(String name) {
        List<Author> authorList = authorRepository.findAuthorByName(name);
        if (authorList.isEmpty()) {
            throw new Exception();
        }
        return convertToDTOList(authorList);
    }

    @SneakyThrows
    @Override
    public List<AuthorDTO> getAuthorByName2(String name) {
        List<Author> authorList = authorRepository.findAuthorByNameSQL(name);
        if (authorList.isEmpty()) {
            throw new Exception();
        }
        return convertToDTOList(authorList);
    }

    @SneakyThrows
    @Override
    public List<AuthorDTO> getAuthorByName3(String name) {
        Specification<Author> authorSpecification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("name"), name);
            }
        });

        List<Author> authorList = authorRepository.findAll(authorSpecification);
        if (authorList.isEmpty()) {
            throw new Exception();
        }
        return convertToDTOList(authorList);
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

    private List<AuthorDTO> convertToDTOList(List<Author> authorList) {
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();
        for (Author author : authorList) {
            List<BookDTO> bookDTOList = author.getBooks()
                    .stream()
                    .map(book -> BookDTO.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build())
                    .toList();

            AuthorDTO authorDTO = AuthorDTO.builder()
                    .books(bookDTOList)
                    .id(author.getId())
                    .name(author.getName())
                    .surname(author.getSurname())
                    .build();

            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }
}
