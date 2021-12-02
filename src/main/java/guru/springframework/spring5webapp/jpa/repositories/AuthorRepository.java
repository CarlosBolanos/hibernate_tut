package guru.springframework.spring5webapp.jpa.repositories;

import guru.springframework.spring5webapp.jpa.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
