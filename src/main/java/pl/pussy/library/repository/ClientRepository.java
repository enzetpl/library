package pl.pussy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pussy.library.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
