package ru.itgirls.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.libraryproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
