package pl.pussy.library.controller.dto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.pussy.library.model.BookCopy;
import pl.pussy.library.service.BookService;
import pl.pussy.library.service.HireService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {

    private static BookService bookService;
    private static HireService hireService;

    private BookCopyMapper(BookService bookService, HireService hireService) {

        BookCopyMapper.bookService = bookService;
        BookCopyMapper.hireService = hireService;
    }

    public static List<BookCopyDTO> mapToCopiesDtos(List<BookCopy> copies) {
        return copies.stream()
                .map(copy -> mapToCopyDto(copy))
                .collect(Collectors.toList());
    }

    private static BookCopyDTO mapToCopyDto(BookCopy copy) {
        return BookCopyDTO.builder()
                .id(copy.getId())
                .bookTitle(bookService.getBookByCopy(copy).getTitle())
                .releaseDate(copy.getReleaseYear())
                .isHire(hireService.isCopyHired(copy))
                .build();
    }
}
