package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    static Connection connect = null;

    public static Connection DBConnect() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String username = "root";
            String password = "Software_123";
            connect = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }
}
