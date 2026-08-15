import java.sql.*;

public class SQLInjection {

    public static void main(String[] args) {

        String username = "admin";
        String password = "12345";

        try {

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
            );


            // Vulnerable SQL query
            String query =
                "SELECT * FROM users WHERE username='"
                + username +
                "' AND password='"
                + password +
                "'";


            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);


            if(rs.next()){
                System.out.println("Login successful");
            }
            else{
                System.out.println("Invalid login");
            }


        } catch(Exception e){

            e.printStackTrace();

        }
    }
}