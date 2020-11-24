package pl.pussy.library.controller.dto;

import lombok.Builder;
import lombok.Getter;
import pl.pussy.library.model.Author;

import java.util.Set;

@Getter
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private Set<Author> authors;
    private int allCopies;
}
