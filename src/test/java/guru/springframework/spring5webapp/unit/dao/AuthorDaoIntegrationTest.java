package guru.springframework.spring5webapp.unit.dao;


import guru.springframework.spring5webapp.dao.AuthorDao;
import guru.springframework.spring5webapp.dao.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    void getByIdTest() throws SQLException {
        Author author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }
}
