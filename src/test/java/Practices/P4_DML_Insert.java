package Practices;

import java.sql.*;

public class P4_DML_Insert {
    //MySql de day5_4 de ..
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        //Q: Insert a new value to the table employees ((10005, 'Max Payne' , 15000) and print the updated table

        String insertQuery = "INSERT INTO employees VALUES(10005, 'Gokhan Agar' , 15000)";
        System.out.println(st.execute(insertQuery));


        ResultSet rs = st.executeQuery("SELECT * from employees");
        while(rs.next()){
            System.out.printf("%-6s %-15.15s %-8s\n", rs.getObject(1), rs.getObject(2),rs.getObject(3));
        }

        //Q: Add new values to the table employees.

        // 1st method

        String [] queries = {"INSERT INTO employees VALUES(10006, 'Matt White' , 18000)",
                "INSERT INTO employees VALUES(10007, 'Simon Red' , 20000)",
                "INSERT INTO employees VALUES(10008, 'Jane Kennedy' , 21000)"};

        int data =0;
        for(String each :queries){
            data+=st.executeUpdate(each);
        }
        System.out.println(data + " entry has been added.");

        // 2nd method

        String [] queries2 = {"INSERT INTO employees VALUES(10009, 'Matt White' , 18000)",
                "INSERT INTO employees VALUES(10010, 'Simon Red' , 20000)",
                "INSERT INTO employees VALUES(10011, 'Jane Kennedy' , 21000)"};

        for(String each : queries2){
            st.addBatch(each);
        }
        int [] rows = st.executeBatch();
        System.out.println(rows.length + " entry has been added.");

    }
}