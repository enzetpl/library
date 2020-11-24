package pl.pussy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pussy.library.model.Book;
import pl.pussy.library.model.BookCopy;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByCopies(BookCopy copy);
}
