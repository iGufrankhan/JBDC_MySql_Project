import java.sql.*;

public class Create_database {

    public static void Create_data() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS my_new_database";

        try (Connection connection = connectivity.getConnection(""); // Initial connection to MySQL server
             Statement statement = connection.createStatement()) {

            // Drop the database if it exists and create a new one
            statement.executeUpdate("DROP DATABASE IF EXISTS my_new_database");
            statement.executeUpdate(createDatabaseQuery);  // Create the database
            System.out.println("Database 'my_new_database' created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
        }
    }
}
