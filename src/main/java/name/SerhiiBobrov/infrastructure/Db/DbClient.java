package name.SerhiiBobrov.infrastructure.Db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DbClient {

    private Connection connection;

    public DbClient(DbConfiguration dbConfiguration) {
        String url = String
                .format("jdbc:mysql://%s:%d/%s", dbConfiguration.getHost(), dbConfiguration.getPort(), dbConfiguration.getDbName());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, dbConfiguration.getUsername(), dbConfiguration.getPassword());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ClassNotFoundException: com.mysql.cj.jdbc.Driver does not exist");
        } catch (SQLException e) {
            throw new RuntimeException("SQLException: " + e.getMessage());
        }
    }

    public Collection<HashMap<String, String>> select(String query) {
        ArrayList<HashMap<String, String>> rows = new ArrayList<>();
        try (Statement statement = connection.createStatement()){

            statement.execute(query);
            ResultSet result = statement.getResultSet();

            while (result.next()) {
                rows.add(new ResultSetToHashMapConverter().convert(result));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return rows;
    }

    public int insert(String table, Map<String, String> data) {
        String[] fields = data.keySet().toArray(new String[0]);

        String query = new InsertQueryGenerator().generate(table, fields);

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            for(int indexColumn = 0; indexColumn < fields.length; indexColumn++) {
                statement.setString(indexColumn + 1, data.get(fields[indexColumn]));
            }

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException("SQLException: " + e.getMessage());
        }
    }
}
