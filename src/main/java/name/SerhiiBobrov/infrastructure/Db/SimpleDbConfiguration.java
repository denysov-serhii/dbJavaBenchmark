package name.SerhiiBobrov.infrastructure.Db;

public class SimpleDbConfiguration implements DbConfiguration {
    @Override
    public String getHost() {
        return "localhost";
    }

    @Override
    public String getDbName() {
        return "dbName";
    }

    @Override
    public String getUsername() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "toor";
    }

    @Override
    public int getPort() {
        return 3306;
    }
}
