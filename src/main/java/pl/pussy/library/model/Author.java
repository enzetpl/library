package pl.pussy.library.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
       @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "books_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "authors_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    void removeBook(Book book) {
        books.remove(book);
        book.getAuthors().remove(this);
    }
}
