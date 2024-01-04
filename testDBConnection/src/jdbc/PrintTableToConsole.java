package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintTableToConsole {

    public static void main(String[] args) {
    	
        // Establish JDBC connection:
    	//String url = "jdbc:mysql://localhost:3306/mydb"; // for mysql.
       // String username = "albertcordina";
        
        String url = "jdbc:postgresql://localhost:5432/albertcordina"; // for postgresql.
        String username = "postgres";
        
        String password = "Forecastoflove1516";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Specify the table name you want to print
            String tableName = "ArrayListToSQL";

            // Create a SQL SELECT query
            String selectQuery = "SELECT * FROM " + tableName;

            // Create a statement and execute the query
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                // Print column names
                int columnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
                }
                System.out.println(); // Move to the next line

                // Print each row
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println(); // Move to the next line
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
