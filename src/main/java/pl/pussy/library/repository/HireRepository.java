package pl.pussy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.model.Hire;

import java.util.List;

public interface HireRepository extends JpaRepository<Hire, Long> {
    List<Hire> findAllByBookCopy(BookCopy copy);
}
