package pl.pussy.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pussy.library.controller.dto.BookCopyMapper;
import pl.pussy.library.controller.dto.BookDTO;
import pl.pussy.library.controller.dto.BookMapper;
import pl.pussy.library.exceptions.ResourceNotFoundException;
import pl.pussy.library.model.Book;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.service.BookService;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        return ResponseEntity.ok(BookMapper.mapToBookDtos(bookService.getBooks()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }


}
