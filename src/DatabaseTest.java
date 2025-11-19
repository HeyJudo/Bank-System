import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseTest {
    public static void main (String [] args){
        String url = "jdbc:mysql://localhost:3306/banking_system";
        String username = "root";
        String password = "Monique1009@";

        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to the database successfully!");
            conn.close();
        } catch (Exception e ){
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}
