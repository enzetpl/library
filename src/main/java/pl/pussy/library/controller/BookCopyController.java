package pl.pussy.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pussy.library.controller.dto.BookCopyDTO;
import pl.pussy.library.controller.dto.BookCopyMapper;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.service.BookCopyService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @GetMapping("/copies")
    public ResponseEntity<List<BookCopy>> getAllCopies() {
        return ResponseEntity.ok(bookCopyService.getAllCopies());
    }

    @GetMapping("/{bookId}/copies")
    public ResponseEntity<List<BookCopyDTO>> getCopiesOfBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(BookCopyMapper.mapToCopiesDtos(bookCopyService.getCopiesOfBook(bookId)));
    }

    @PostMapping("/{bookId}/copies")
    public ResponseEntity<?> addCopyOfBook(@PathVariable Long bookId, @RequestBody BookCopy copy) {
        return ResponseEntity.ok(bookCopyService.addCopyOfBook(bookId, copy));
    }
}
