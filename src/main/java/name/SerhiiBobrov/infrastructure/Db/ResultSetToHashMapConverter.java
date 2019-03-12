package name.SerhiiBobrov.infrastructure.Db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

class ResultSetToHashMapConverter {
    HashMap<String, String> convert(ResultSet resultSet) throws SQLException {
        HashMap<String, String> map = new HashMap<>();

        for (int columnIndex = 1; columnIndex <= resultSet.getMetaData().getColumnCount(); columnIndex++) {
            map.put(resultSet.getMetaData().getColumnName(columnIndex), resultSet.getString(columnIndex));
        }

        return map;
    }
}
