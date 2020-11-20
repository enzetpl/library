package pl.pussy.library.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.pussy.library.model.Author;
import pl.pussy.library.model.Book;
import pl.pussy.library.repository.AuthorRepository;
import pl.pussy.library.repository.BookRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Book book = new Book();
        Book book1 = new Book();
        Author author = new Author();
        author.setFirstname("firstname1");
        author.setLastname("lastname1");
        book.setTitle("title1");
        book1.setTitle("title2");
        bookRepository.save(book);
        bookRepository.save(book1);
        authorRepository.save(author);
        author.getBooks().add(book);
        authorRepository.save(author);
        author.getBooks().add(book1);
    }
}
