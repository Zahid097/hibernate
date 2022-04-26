package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private Connection connection = null;


    public Util() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "yiman");
    }

    public Util(Connection connection) {

    }

    public Connection getConnection() {
        return connection;
    }
}