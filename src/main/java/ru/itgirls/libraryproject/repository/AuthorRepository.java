package ru.itgirls.libraryproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.itgirls.libraryproject.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    List<Author> findAuthorByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM AUTHOR WHERE name = ?")
    List<Author> findAuthorByNameSQL(String name);

}
