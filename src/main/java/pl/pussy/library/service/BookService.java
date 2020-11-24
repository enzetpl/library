package pl.pussy.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.pussy.library.exceptions.ResourceNotFoundException;
import pl.pussy.library.model.Author;
import pl.pussy.library.model.Book;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.repository.AuthorRepository;
import pl.pussy.library.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("book with id: " + id + " not found"));
    }

    @Transactional
    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id: "+ id + " not found"));
        authorRepository.findAllByBooks(book).stream().forEach(author -> author.getBooks().remove(book));
        bookRepository.deleteById(id);
    }

    public Book getBookByCopy(BookCopy copy) {
        return bookRepository.findByCopies(copy)
                .orElseThrow(() -> new ResourceNotFoundException());
    }
}
