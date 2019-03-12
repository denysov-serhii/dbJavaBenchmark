package name.SerhiiBobrov.core.userPoint;

import name.SerhiiBobrov.infrastructure.Db.DbClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserPointDbMapper implements UserPointMapper {
    private final static String tableName = "userPoints";

    private DbClient dbClient;
    private UserPointFactory userPointFactory;

    public UserPointDbMapper(DbClient dbClient, UserPointFactory userPointFactory) {
        this.dbClient = dbClient;
        this.userPointFactory = userPointFactory;
    }

    public Collection<UserPoint> loadAll() {
        ArrayList<UserPoint> userPoints = new ArrayList<>();
        Collection<HashMap<String, String>> rows =  dbClient.select("SELECT * FROM " + tableName);

        for(HashMap<String, String> row : rows) {
            userPoints.add(userPointFactory.create(row));
        }

        return userPoints;
    }

    @Override
    public UserPoint create(Map<String, String> data) {
        dbClient.insert(tableName, data);

        return userPointFactory.create(data);
    }
}
