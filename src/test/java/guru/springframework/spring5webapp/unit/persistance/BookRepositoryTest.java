package guru.springframework.spring5webapp.unit.persistance;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository userRepository;

    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count();

        assertThat(countBefore).isEqualTo(4);
        Book savedBook = bookRepository.save(new Book("my book", "1234", "self", 1L));

        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
}
