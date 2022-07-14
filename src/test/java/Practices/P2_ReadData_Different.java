package Practices;

import java.sql.*;

public class P2_ReadData_Different {

        //MySql de day4 de..personnel tablesu


        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
           

            String query = "Select * from personnel";
            ResultSet resultSet = st.executeQuery(query);
            System.out.println(resultSet.getRow()); //0
            resultSet.first(); // Go to the first record
            Object firstObject = resultSet.getObject(1);
            System.out.println(firstObject.toString()); // 123456789

            // Print the object on the second row.
            resultSet.next();
            Object secondObject = resultSet.getObject(1);
            System.out.println(secondObject.toString());

            
            // Print the data on the row:5 column:1

            resultSet.absolute(5);
            Object givenData = resultSet.getObject(1);
            System.out.println(givenData.toString());
            
            // Print all the list
            
            resultSet.absolute(0);  // Must return to first row first
            while(resultSet.next()){
                Object ids =resultSet.getObject(1);
                System.out.println(ids);
            }


            resultSet.absolute(0);
            while(resultSet.next()){
                Object names =resultSet.getObject("name");
                System.out.println(names);
            }


            resultSet.absolute(0);
            while(resultSet.next()){
                Object cities =resultSet.getObject("city");
                System.out.println(cities);
            }

        }

}

