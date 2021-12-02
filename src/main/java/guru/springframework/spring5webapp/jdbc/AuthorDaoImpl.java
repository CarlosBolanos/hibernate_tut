package guru.springframework.spring5webapp.jdbc;

import guru.springframework.spring5webapp.jdbc.domain.Author;
import guru.springframework.spring5webapp.jdbc.mapper.AuthorMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AuthorDaoImpl implements AuthorDao{
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Author getById(Long id) throws SQLException {
        String queryString = "SELECT * FROM author where id = ?";
        return (Author) jdbcTemplate.queryForObject(queryString, new AuthorMapper(), id);
    }
}
