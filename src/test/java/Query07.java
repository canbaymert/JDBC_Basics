import java.sql.*;

public class Query07 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=UTC", "root", "Enter your password here.");


        // STATEMENT:
        // Statement st = con.createStatement();
        // st.executeUpdate("insert into students values (200, John Stones', 10, 'M')");

        // PreparedStatement : Values may be sent as parameters.
        PreparedStatement ps = con.prepareStatement("insert into students values (?, ?, ? ,?)");
        ps.setInt(1,201);
        ps.setString(2,"John Stones");
        ps.setString(3,"10");
        ps.setString(4,"M");

        ps.executeUpdate();
        System.out.println("Data has been added.");
    }
}