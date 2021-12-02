package guru.springframework.spring5webapp.unit;

import guru.springframework.spring5webapp.jpa.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Spring5webappApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testBookRepository(){
        long count = bookRepository.count();
        assertThat(count).isGreaterThan(0);
    }

    @Test
	public void contextLoads() {
        
	}

}
