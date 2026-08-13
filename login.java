import java.sql.*;

public class VulnerableLogin {
    public boolean login(String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        Statement stmt = conn.createStatement();
        
        // DANGEROUS: directly concatenating user input into SQL
        String query = "SELECT * FROM users WHERE username = '" + username + 
                        "' AND password = '" + password + "'";
        
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }
}