import java.sql.*;

public class Read_operation {

    // Method to read the first 'top' number of records
    public static void readLimit(int top) {
        // Correct SQL query with direct insertion of the limit value
        String query = "SELECT * FROM my_student LIMIT " + top;

        try (Connection connection = connectivity.getConnection("my_new_database");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and print each record
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Marks: " + resultSet.getDouble("marks"));
                System.out.println("-----------------------------");  // Add separator between records
            }

        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to read records based on a condition (e.g., column name and value)
    public static void read_cond(String columnName, int value) {


        // Correct SQL query with parameterized column and value
        String query = "SELECT * FROM my_student WHERE " + columnName + " = ?";

        try (Connection connection = connectivity.getConnection("my_new_database");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the value for the parameter
            preparedStatement.setInt(1, value);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and print each record
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("-----------------------------");  // Add separator between records
            }

        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

