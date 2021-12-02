package guru.springframework.spring5webapp.jdbc;

import guru.springframework.spring5webapp.jdbc.domain.Author;

import java.sql.SQLException;

public interface JdbcAuthorDao {
    Author getById(Long id) throws SQLException;
}
