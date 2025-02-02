
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Update_operation
{

    public static void Update()

    {
        String insertQuery = "Update my_student set age=? where id=?";

        try {

            Connection connection = connectivity.getConnection("my_new_database");

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the prepared statement
            preparedStatement.setInt(1,40);
            preparedStatement.setInt(2,1);


            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully Updated");
            } else {
                System.out.println("No record found with the given ID.");
            }

            // Close the connection and statement to prevent memory leaks
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        }



    }




// parameter

        public static void Update(int id, int newAge) {
            String updateQuery = "UPDATE my_student SET age = ? WHERE id = ?";

            try {
                // Get connection
                Connection connection = connectivity.getConnection("my_new_database");

                // Prepare the statement
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

                // Set the values for the prepared statement
                preparedStatement.setInt(1, newAge);  // Set the new age value
                preparedStatement.setInt(2, id);      // Set the id of the student to update

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Successfully Updated");
                } else {
                    System.out.println("No record found with the given ID.");
                }

                // Close the connection and statement to prevent memory leaks
                preparedStatement.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println("Error updating data: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            // Example of how to call the update method
            Update(40, 25);  // Update the student with ID 40 and set their age to 25
        }
    }








