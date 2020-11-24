package pl.pussy.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String cardNumber;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Set<Hire> hires;
}
