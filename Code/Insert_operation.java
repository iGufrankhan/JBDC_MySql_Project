import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_operation {


    public static void insert() {
        String insertQuery = "INSERT INTO my_student (name, age, marks) VALUES (?, ?, ?)";

        try {

            Connection connection = connectivity.getConnection("my_new_database");

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the prepared statement
            preparedStatement.setString(1,"nawneet" );
            preparedStatement.setInt(2, 13);
            preparedStatement.setDouble(3, 93.4);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("ERROR 404 Found");
            }

            // Close the connection and statement to prevent memory leaks
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

     // with parameter we can insert the value;
    public static void insert(String name, int age, double marks) {
        String insertQuery = "INSERT INTO my_student (name, age, marks) VALUES (?, ?, ?)";

        try {

            Connection connection = connectivity.getConnection("my_new_database");

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, marks);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("ERROR 404 Found");
            }

            // Close the connection and statement to prevent memory leaks
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

}