import java.sql.*;


public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Enter your password here.");

        //Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("select * from students");

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Number of Columns: " + rsmd.getColumnCount());

        System.out.println("Name of 1st Column : " + rsmd.getColumnName(1));
        System.out.println("Name of 2nd Column : " + rsmd.getColumnName(2));
        System.out.println("Name of 3rd Column : " + rsmd.getColumnName(3));
        System.out.println("Name of 4rd Column : " + rsmd.getColumnName(4));

        System.out.println("===================================");

        System.out.println("Data Type of 1st Column : " + rsmd.getColumnTypeName(1));
        System.out.println("Data Type of 2nd Column : " + rsmd.getColumnTypeName(2));
        System.out.println("Data Type of 3rd Column : " + rsmd.getColumnTypeName(3));
        System.out.println("Data Type of 4th Column : " + rsmd.getColumnTypeName(4));

        System.out.println("Table Name : " + rsmd.getTableName(1));

        while (rs.next()){
            System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
        }

    }
}