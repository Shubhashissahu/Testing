import java.sql.*;

public class ProductSearch {

    public static void searchProduct(String productName) {

        try {

            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shop",
                "root",
                "password"
            );

            Statement statement = connection.createStatement();

            // ❌ Vulnerable: User input directly concatenated into SQL
            String query = 
                "SELECT * FROM products WHERE name LIKE '%" 
                + productName 
                + "%'";

            System.out.println(query);

            ResultSet rs = statement.executeQuery(query);


            while(rs.next()) {

                System.out.println(
                    rs.getString("name") 
                    + " - " 
                    + rs.getDouble("price")
                );
            }


            connection.close();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        searchProduct("Laptop");
    }
}