package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_db {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Sakshi@006";

        // JDBC variables for managing connection and executing queries
        Connection con = null;
        Statement stmt = null;

        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            con = DriverManager.getConnection(url, user, password);

            // Create a Statement object for executing SQL queries
            stmt = con.createStatement();

            // SQL query to create a database named my_db
            String sql = "select name from t1 where id=1";

            // Execute the SQL query
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            String name=rs.getString("name");

            System.out.println(name);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the Statement and Connection objects
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
