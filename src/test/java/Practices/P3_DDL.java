package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_DDL {
            /*
                  execute() returns with             DDL : False    DML : True
                  executeUpdate() returns with       DDL : 0  DML : Number of the added rows.
             */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q: Create a table named brands. brand_id int, brand_name VARCHAR(15), number_of_employees int

        String createQuery = "create table brands(brand_id int, brand_name VARCHAR(15), number_of_employees int)";

        // With execute () method
        boolean s1 = st.execute(createQuery);
        System.out.println("Brands table has been created " + s1);

        // With executeUpdate() method

        int s2 = st.executeUpdate(createQuery);
        System.out.println("Brands table has been created " + s2);

        // Q: Delete the table brands

        String dropQuery = "DROP table brands";
        st.execute(dropQuery);
        System.out.println("Brands table has been deleted");

        // Q : Add a new column to the table brands  {number_of_offices int}

        String alterQuery = "ALTER table brands ADD number_of_offices int";  // Adds to the end as default
        st.executeUpdate(alterQuery);

        // Q : Add a new column to the table brands after brand_id {number_of_departments int}

        String alterQuery2 = "ALTER table brands ADD number_of_departments int AFTER brand_id";
        st.executeUpdate(alterQuery2);
//
        // Q : Rename the table brands as brand

        String alterQuery3 = "Alter table brands RENAME TO brands";
        st.execute(alterQuery3);


        // Q : Change the brand_name column as name

        String alterQuery4 = "Alter table brands RENAME column brand_name to name";
        st.execute(alterQuery4);

        // Q : Change the data type of brand_name column as char(20)
        st.execute("alter table brands modify brand_name char(20)");

    }
}