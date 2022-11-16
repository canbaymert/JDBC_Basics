import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1) Install Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2) Create a connection
        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/school?serverTimezone=UTC", "root", "Enter your password here");
        // Database Name = school


        //3) Statement: Creates an object to write SQL codes.
        Statement st = con.createStatement();

        //4) ResultSet:
        ResultSet data = st.executeQuery("select * from ogrenciler");

        //5) Get results

        while (data.next()){

            // By index
            // System.out.println(data.getInt(1) + data.getString(2)
            // + data.getString(3) + data.getString(4));

            // By column name
            // System.out.println(data.getInt("okul_no") + data.getString("ogrenci_ismi")
            // + data.getString("sinif") + data.getString("cinsiyet"));

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", data.getInt(1), data.getString(2), data.getString(3), data.getString(4));
        }

        //6) Close connection
        con.close();
        st.close();
        data.close();
    }
}