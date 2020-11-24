package pl.pussy.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int releaseYear;
    @ManyToOne
    private Book book;
    @OneToMany
    @JoinColumn(name = "book_copy_id")
    @JsonIgnore
    private Set<Hire> hires;
}
