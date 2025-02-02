import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DropTrunc_Table {

    // Method to drop the table from the database
    public static void dropTable() {
        String dropQuery = "DROP TABLE my_student";

        try (Connection connection = connectivity.getConnection("my_new_database");
             Statement statement = connection.createStatement()) {

            // Execute the drop table operation
            statement.executeUpdate(dropQuery);
            System.out.println("Successfully dropped the table from the database.");

        } catch (SQLException e) {
            System.out.println("Error in dropping the table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to truncate all rows from the table
    public static void truncateTable() {
        String truncateQuery = "TRUNCATE TABLE my_student";

        try (Connection connection = connectivity.getConnection("my_new_database");
             Statement statement = connection.createStatement()) {

            // Execute the truncate table operation
            statement.executeUpdate(truncateQuery);
            System.out.println("Successfully deleted all data from the table.");

        } catch (SQLException e) {
            System.out.println("Error in truncating the table: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
