import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        //Q: Create a table of workers. id int, department VARCHAR(10), salary int

        String query = "create table workers (id int, department varchar(10), salary int)";

        //st.execute(query);
        System.out.println("Workers table has been created.");

        // Q: Delete the table workers .
        st.execute("drop table workers");
        System.out.println("Workers table has been deleted.");

        //Q: Add two columns to the table workers name varchar(20), city varchar(10)
        st.execute("alter table workers add name varchar(20)");
        st.execute("alter table workers add city varchar(10)");
        System.out.println("2 columns has been added.");

        // Q: Change the name of the city column to country.
        st.execute("alter table workers rename column city to country");
        System.out.println("Column name has been changed.");

        //Q: Rename the table as employees
        st.execute("alter table workers rename to employee");
        System.out.println("Table name has been changed.");

        //Q: Change the data type of the country column to char(30)
        st.execute("alter table employee modify country char(30)");
        System.out.println("Data type has been changed.");

    }
}