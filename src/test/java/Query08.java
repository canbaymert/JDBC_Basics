import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q1: Create a table named Products (id int, name varchar(10), price int)
        // st.execute("create table products (id int, name varchar(10), price int)");

        // Q2: Add all the given data to the products table
        // Use PreparedStatement
        // 1) Create a proper POJO (Plain Old Java Object) class
        // 2) Create a collection to keep the data in the POJO class
        // 3) Add the data with a loop

        List<QueryProduct_POJO> records = new ArrayList<>();
        records.add(new QueryProduct_POJO(101,"Laptop",6500));
        records.add(new QueryProduct_POJO(102,"PC",4500));
        records.add(new QueryProduct_POJO(103,"Mobile",4500));
        records.add(new QueryProduct_POJO(104,"Motherboard",1500));
        records.add(new QueryProduct_POJO(105,"Keyboard",200));
        records.add(new QueryProduct_POJO(106,"Mouse",100));

        PreparedStatement table = con.prepareStatement("insert into products values(?, ?, ?)");
        for(QueryProduct_POJO each:records){
            table.setInt(1, each.getId());
            table.setString(2, each.getName());
            table.setDouble(3, each.getPrice());

            table.addBatch();   
        }
        table.executeBatch();
        System.out.println("The given data has been added to the database.");

        con.close();
        st.close();
        table.close();

    }
}