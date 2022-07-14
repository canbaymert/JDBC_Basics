package Practices;

import java.sql.*;

public class P1_ReadData {

    //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");
        Statement st = con.createStatement();

        // Q1: Print all records on the students table

        ResultSet records = st.executeQuery("select * from students");
        while (records.next()) {
            System.out.printf("%-6d  %-15.15s  %-8s  %-5d\n", records.getInt(1), records.getString(2),
                    records.getString(3), records.getInt(4));
        }

        // Q2: Print all records on the students table with a greater exam point than 90
        ResultSet records90 = st.executeQuery("select * from students where exam_point>90");

        while (records90.next()) {
            System.out.printf("\"%-6d  %-15.15s  %-8d\n", records90.getInt(1), records90.getString(2), records90.getInt(4));

        }

        // Q3: Print all the information of the student with id=124 
        ResultSet id124 = st.executeQuery("select * from students where id= 124");
        while (id124.next()) {
            System.out.printf("%-6s  %-15.15s  %-8s  %-5s\n", id124.getObject(1), id124.getObject(2), id124.getObject(3), id124.getObject(4));

        }

        // Q4: Print the name of the students with exam point between 70 and 90

        ResultSet point7090 = st.executeQuery("select name, exam_point from students where exam_point between '70' AND '90'");
        while(point7090.next()){
        System.out.printf("%-16s  %-16s \n", point7090.getObject(1), point7090.getObject(2));
       }

        // Q5: Print the name and the parent name of the students whose has 'e' as the second letter in their names. 
        ResultSet name2E_parentName = st.executeQuery("select name, parent_name from students where name LIKE '_e%'");
        while (name2E_parentName.next()) {
            System.out.printf("%-16s  %-16s \n", name2E_parentName.getObject(1), name2E_parentName.getObject(2));
        }

    }

}


