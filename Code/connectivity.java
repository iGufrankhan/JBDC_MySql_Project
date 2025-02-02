import java.sql.*;

public class connectivity {

    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String username = "root";
    private static final String password = "Gufran123";

    // Method to establish a connection to the specific database
    public static Connection getConnection(String database) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish and return the connection to the specified database
            return DriverManager.getConnection(url + database, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL driver: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }
}
