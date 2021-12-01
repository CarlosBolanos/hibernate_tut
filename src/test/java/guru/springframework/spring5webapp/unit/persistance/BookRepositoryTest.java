package guru.springframework.spring5webapp.unit.persistance;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(4);
        bookRepository.save(new Book("my book", "1234", "self", UUID.randomUUID()));

        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }
}
