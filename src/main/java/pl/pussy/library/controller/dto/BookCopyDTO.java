package pl.pussy.library.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookCopyDTO {
    private Long id;
    private String bookTitle;
    private int releaseDate;
    private boolean isHire = false;
}
