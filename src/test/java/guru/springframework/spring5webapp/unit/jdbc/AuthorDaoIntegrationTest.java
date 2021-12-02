package guru.springframework.spring5webapp.unit.jdbc;


import guru.springframework.spring5webapp.jdbc.AuthorDao;
import guru.springframework.spring5webapp.jdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.jdbc"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void getByIdTest() throws SQLException {
        Author author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }
}
