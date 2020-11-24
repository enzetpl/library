package pl.pussy.library.controller.dto;

import pl.pussy.library.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {
    public static List<BookDTO> mapToBookDtos(List<Book> books) {
        return books.stream()
                .map(BookMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    private static BookDTO mapToBookDto(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authors(book.getAuthors())
                .allCopies(book.getCopies().size())
                .build();
    }
}
