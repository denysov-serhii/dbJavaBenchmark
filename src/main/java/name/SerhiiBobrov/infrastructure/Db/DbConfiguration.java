package name.SerhiiBobrov.infrastructure.Db;

public interface DbConfiguration {
    String getHost();
    String getDbName();
    String getUsername();
    String getPassword();
    int getPort();
}
