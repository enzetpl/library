package pl.pussy.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.pussy.library.model.Book;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.repository.BookCopyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookCopyService {

    private final BookService bookService;
    private final BookCopyRepository bookCopyRepository;
    public List<BookCopy> getCopiesOfBook(Long bookId) {
        Book book = bookService.getBookById(bookId);
        return bookCopyRepository.findAllByBook(book);
    }

    public List<BookCopy> getAllCopies() {
        return bookCopyRepository.findAll();
    }

    public BookCopy addCopyOfBook(Long bookId, BookCopy copy) {
        Book book = bookService.getBookById(bookId);
        book.getCopies().add(copy);
        return bookCopyRepository.save(copy);
    }
}
