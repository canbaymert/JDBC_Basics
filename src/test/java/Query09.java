import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query09 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        PreparedStatement table = con.prepareStatement("insert into products values(?, ?, ?)");

        // Q: Add the given data to the products table

        List<QueryProduct_POJO> records = new ArrayList<>();
        records.add(new QueryProduct_POJO(200, "Asus", 7500));
        records.add(new QueryProduct_POJO(201, "HP", 8500));
        records.add(new QueryProduct_POJO(202, "Acer", 9500));
        records.add(new QueryProduct_POJO(203, "MSI", 11500));
        records.add(new QueryProduct_POJO(204, "Razer", 1200));
        records.add(new QueryProduct_POJO(205, "SteelSeries", 1000));

        PreparedStatement table1 = con.prepareStatement("insert into products values(?, ?, ?)");
        for(QueryProduct_POJO each:records){
            table1.setInt(1, each.getId());
            table1.setString(2, each.getName());
            table1.setDouble(3, each.getPrice());
            table1.addBatch();
        }
        table1.executeBatch();
        System.out.println("The given data has been added to the database.");

    }
}
