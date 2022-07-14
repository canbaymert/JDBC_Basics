import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=UTC", "root", "Enter your password here");

        Statement st = con.createStatement();

        // Q01: Get the data from students table

        ResultSet data = st.executeQuery("select * from students where sex = 'M'");

        while (data.next()){
            //System.out.println(data.getInt(1) + data.getString(2)
                    //+ data.getString(3) + data.getString(4));


            System.out.printf("%-6d %-15.15s %-8s %-8s\n", data.getInt(1), data.getString(2), data.getString(3), data.getString(4));
        }

        // Q02: Get the data of 9th grade female students

        System.out.println("==========================================================================");

        ResultSet data2 = st.executeQuery("select * from students where class=9 and sex='F'");

        while (data2.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", data2.getInt(1), data2.getString(2), data2.getString(3), data2.getString(4));
        }

        con.close();
        st.close();
        data.close();
    }
}
