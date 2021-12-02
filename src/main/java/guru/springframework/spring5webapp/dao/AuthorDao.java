package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.dao.domain.Author;

import java.sql.SQLException;


public interface AuthorDao {
    Author getById(Long id) throws SQLException;
}
