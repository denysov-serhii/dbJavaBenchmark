package name.SerhiiBobrov.infrastructure.Db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileDbConfiguration implements DbConfiguration {

    private final static String DB_NAME = "dbName";
    private final static String HOST = "host";
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static String PORT = "port";

    private Properties properties;

    public FileDbConfiguration(String fileName) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (stream == null) {
            throw new RuntimeException("db.properties file not found");
        }

        try {
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String getHost() {
        return properties.getProperty(HOST);
    }

    @Override
    public String getDbName() {
        return properties.getProperty(DB_NAME);
    }

    @Override
    public String getUsername() {
        return properties.getProperty(USERNAME);
    }

    @Override
    public String getPassword() {
        return properties.getProperty(PASSWORD);
    }

    @Override
    public int getPort() {
        return Integer.parseInt(properties.getProperty(PORT));
    }
}
