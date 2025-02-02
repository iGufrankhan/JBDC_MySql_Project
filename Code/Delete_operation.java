import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_operation {

    // Delete all rows from the 'my_student' table
    public static void deleteAllRows() {
        String deleteQuery = "DELETE FROM my_student";

        try (Connection connection = connectivity.getConnection("my_new_database");
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // Execute the delete operation
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully deleted all rows.");
            } else {
                System.out.println("ERROR 404: No rows to delete.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting all rows: " + e.getMessage());
            e.printStackTrace();
        }
    }






    // Delete a specific row based on the provided ID
    public static void Delete_Ind_row(int id) {
        String deleteQuery = "DELETE FROM my_student WHERE id = ?";

        try (Connection connection = connectivity.getConnection("my_new_database");
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // Set the ID parameter for the delete query
            preparedStatement.setInt(1, id);

            // Execute the delete operation
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully deleted the row with ID " + id);
            } else {
                System.out.println("ERROR 404: Data not found for the given ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
