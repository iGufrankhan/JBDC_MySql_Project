import java.sql.*;

public class Create_Table {

    public static void create() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS my_student (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "age INT, " +
                "marks DOUBLE" +
                ");";

        // Establish the connection to the specific database after it has been created
        try (Connection connection = connectivity.getConnection("my_new_database")) {

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database.");

                try (Statement statement = connection.createStatement()) {
                    // Execute the SQL query to create the table
                    statement.executeUpdate(createTableQuery);
                    System.out.println("Table 'my_student' created successfully.");
                }
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
