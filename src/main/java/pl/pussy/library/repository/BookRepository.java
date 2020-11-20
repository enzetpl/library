package pl.pussy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pussy.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
