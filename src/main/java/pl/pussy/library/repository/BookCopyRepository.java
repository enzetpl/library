package pl.pussy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pussy.library.model.Book;
import pl.pussy.library.model.BookCopy;

import java.util.List;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
    List<BookCopy> findAllByBook(Book book);
}
