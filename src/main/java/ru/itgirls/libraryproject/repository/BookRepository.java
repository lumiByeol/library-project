package ru.itgirls.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirls.libraryproject.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
