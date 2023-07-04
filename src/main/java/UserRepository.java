import java.sql.*;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static final String UPDATE_BY_ID = """
            UPDATE users SET name = ? WHERE ID = ?""";

    private static final String DELETE_BY_ID = """
            DELETE FROM users WHERE id = ?
            """;
    private static final String FIND_BY_ID_QUERY = """
            SELECT * FROM users WHERE id = ?
            """;

    private static final String FIND_BY_ID_ALL = """
            SELECT * FROM users u
            """;

    private static final String SAVE = """
            INSERT INTO users(name, surname, age, username, password, inserted_date_at_utc)\s
            values (?, ?, ?, ?, ?, ?);""";

    public List<User> findByIdAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_ALL)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setUserName(resultSet.getString("username"));
                    user.setInsertedAtUtc(resultSet.getTimestamp("inserted_date_at_utc").toLocalDateTime());
                    users.add(user);
                }
                return users;
            }

        }

    }

    public void updateByID(Long id, String name) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)
        ) {
            preparedStatement.setLong(2, id);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        }
    }

    public void deleteById(Long id) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }
    }
    public User findById(Long id) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_QUERY)
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                User user = new User();
                while (resultSet.next()) {
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setUserName(resultSet.getString("username"));
                    user.setInsertedAtUtc(resultSet.getTimestamp("inserted_date_at_utc").toLocalDateTime());
                }
                return user;
            }
        }
    }

    public void save(User user) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(SAVE)
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setLong(3, user.getAge());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setTimestamp(6, new Timestamp(user.getInsertedAtUtc().toInstant(ZoneOffset.UTC).toEpochMilli()));
            preparedStatement.execute();
        }
    }
}

