package Practices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class P5_CRUD {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC";
        Connection con = DriverManager.getConnection(url, "root", "Enter your password here."); 

        Statement st = con.createStatement();  

        // Q: Create a table named classes (id int, class_name varchar(15), education_period int)
        String createQuery = "create table Classes (id int, class_name VARCHAR(15), education_period_gun int)";

        st.execute(createQuery);
        System.out.println("Classes table has been created.");

        // Create a POJO Class id(int), class_name(String), education_period(int) 
        
        List<POJO_Class> Classes = new ArrayList<>();
        Classes.add(new POJO_Class(100, "Java",50));
        Classes.add(new POJO_Class(101, "SQL",10));
        Classes.add(new POJO_Class(102, "JDBC",2));
        Classes.add(new POJO_Class(103, "APi",12));
        Classes.add(new POJO_Class(104, "JENKİNS",1));
        Classes.add(new POJO_Class(105, "Selenium",25));
        Classes.add(new POJO_Class(106, "Appium",10));
        Classes.add(new POJO_Class(107, "SDLC",10));

        PreparedStatement table = con.prepareStatement("INSERT INTO Classes VALUES (?,?,?)");

        for (POJO_Class d : Classes){
            table.setInt(1, d.getId());
            table.setString(2, d.getclass_name());
            table.setInt(3, d.geteducation_period());

            table.addBatch();
        }

        table.executeBatch();

        System.out.println("The given data has been added to the Table Classes");
    }

}
