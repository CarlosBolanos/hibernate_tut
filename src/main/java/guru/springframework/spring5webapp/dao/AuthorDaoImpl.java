package guru.springframework.spring5webapp.dao;

import guru.springframework.spring5webapp.dao.domain.Author;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class AuthorDaoImpl implements AuthorDao{

    private final DataSource source;

    public AuthorDaoImpl(DataSource source) {
        this.source = source;
    }

    @Override
    public Author getById(Long id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            ps = connection.prepareStatement("SELECT * FROM author where id = ?");
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            // statement = connection.createStatement();
            // resultSet = statement.executeQuery("SELECT * FROM author where id = " + id);

            if(resultSet.next()){
                Author author = new Author();

                author.setId(id);
                author.setUsername(resultSet.getString("username"));
                author.setPassword(resultSet.getString("password"));
                author.setEmail(resultSet.getString("email"));

                return author;
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        } finally {
            if(resultSet != null){
                resultSet.close();
            }

            if(statement != null){
                statement.close();
            }

            if(connection != null){
                connection.close();
            }
        }

        return null;
    }
}
