package guru.springframework.spring5webapp.hibernate;

import guru.springframework.spring5webapp.hibernate.domain.AuthorEntity;

public interface HibernateAuthorDao {
    AuthorEntity getById(Long id);

    AuthorEntity findAuthorByName(String username);

    AuthorEntity saveNewAuthor(AuthorEntity author);

    AuthorEntity updateAuthor(AuthorEntity author);

    void deleteAuthorById(Long id);
}
