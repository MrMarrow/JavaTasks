package jdbc_task.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    private static String CONNECT_URL = "jdbc:mysql://localhost:3306/banktask_schema";
    private static Connection connection;

    public static void setConnect(String userName, String password) throws ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(CONNECT_URL, userName, password);
            System.out.println("connect successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    public static Connection getConnection() {
        return connection;
    }
}
