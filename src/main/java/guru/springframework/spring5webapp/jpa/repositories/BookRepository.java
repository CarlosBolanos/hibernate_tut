package guru.springframework.spring5webapp.jpa.repositories;

import guru.springframework.spring5webapp.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
