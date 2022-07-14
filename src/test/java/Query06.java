import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q1: Add a new department info (80, 'R&D', 'PARIS')

        int s1 = st.executeUpdate("insert into departments values (80, 'R&D', 'PARIS')");
        System.out.println(s1+ " Raw has been added.");

        // executeUpdate returns the number of the added rows.

        // Q2; Add more than one record to the table
        // 1st way

        String [] data1 = {"insert into departments values (95, 'SALES', 'IZMIR')",
                "insert into departments values (85, 'FINANCE', 'NEW YORK')",
                        "insert into departments values (75, 'HUMAN RELATIONS', 'BERLIN')"};
        int count=0;
        for(String each:data1){
            count = count + st.executeUpdate(each);
        }
        System.out.println(count + " data has been added.");

        // 2nd way
        String [] data2 = {"insert into departments values (95, 'SALES', 'IZMIR')",
                "insert into departments values (85, 'FINANCE', 'NEW YORK')",
                "insert into departments values (75, 'HUMAN RELATIONS', 'BERLIN')"};

        for(String each:data2){
            st.addBatch(each);  // Put all data together
        }
        st.executeBatch();      // Sends it at once

        System.out.println("The given data has been added to the database.");



    }
}