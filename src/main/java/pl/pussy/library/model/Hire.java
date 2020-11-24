package pl.pussy.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    BookCopy bookCopy;
    @ManyToOne
    Client client;
    private LocalDate hireDate;
    private LocalDate returnDate;
    private boolean isReturned;
}
