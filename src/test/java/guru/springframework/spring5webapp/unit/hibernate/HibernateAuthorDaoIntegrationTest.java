package guru.springframework.spring5webapp.unit.hibernate;


import guru.springframework.spring5webapp.hibernate.HibernateAuthorDao;
import guru.springframework.spring5webapp.hibernate.domain.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.hibernate"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HibernateAuthorDaoIntegrationTest {

    @Autowired
    HibernateAuthorDao authorDao;

    @Test
    void getByIdTest() throws SQLException {
        AuthorEntity author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        AuthorEntity author = authorDao.findAuthorByName("carlos");
        assertThat(author).isNotNull();
    }

    @Test
    void testSaveAuthor() {
        AuthorEntity author = new AuthorEntity("new author", "password", "author@email.com");
        AuthorEntity saved = authorDao.saveNewAuthor(author);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void testUpdateAuthor() {
        AuthorEntity author = new AuthorEntity("new author", "password", "author@email.com");
        AuthorEntity saved = authorDao.saveNewAuthor(author);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        saved.setUsername("new author2");
        AuthorEntity updated = authorDao.updateAuthor(saved);

        assertThat(updated.getUsername()).isEqualTo("new author2");
    }

    @Test
    void testDeleteAuthor() {
        AuthorEntity author = new AuthorEntity("new author", "password", "author@email.com");
        AuthorEntity saved = authorDao.saveNewAuthor(author);

        authorDao.deleteAuthorById(saved.getId());


        AuthorEntity deleted = authorDao.getById(saved.getId());
        assertThat(deleted).isNull();

        assertThat(authorDao.getById(saved.getId()));

    }
}
