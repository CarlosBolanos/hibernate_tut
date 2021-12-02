package guru.springframework.spring5webapp.jdbc.mapper;


import guru.springframework.spring5webapp.jdbc.domain.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();

        author.setId(rs.getLong("id"));
        author.setUsername(rs.getString("username"));
        author.setPassword(rs.getString("password"));
        author.setEmail(rs.getString("email"));

        return author;
    }
}
