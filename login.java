import java.sql.*;

public class login {

    public static boolean authenticate(String username, String password) {

        boolean isValid = false;

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password"
            );

            Statement stmt = con.createStatement();

            // ❌ Vulnerable query
            String query = "SELECT * FROM users WHERE username='"
                    + username
                    + "' AND password='"
                    + password
                    + "'";

            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                isValid = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }


    public static void main(String[] args) {

        String username = "admin";
        String password = "1234";

        if(authenticate(username, password)) {
            System.out.println("Login Successful");
        }
        else {
            System.out.println("Invalid Login");
        }
    }
}