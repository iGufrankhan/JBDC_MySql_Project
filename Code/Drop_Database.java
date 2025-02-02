import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Drop_Database {

    public static void dropDatabase() {
        // SQL query to drop the database
        String dropDatabaseQuery = "DROP DATABASE my_new_database";

        try (Connection connection = connectivity.getConnection("mysql"); // Connecting to MySQL server (not specific database)
             Statement statement = connection.createStatement()) {

            // Execute the query to drop the database
            statement.executeUpdate(dropDatabaseQuery);
            System.out.println("Database 'my_new_database' has been successfully dropped.");

        } catch (SQLException e) {
            System.out.println("Error dropping the database: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
