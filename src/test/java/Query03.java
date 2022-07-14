import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q1: Print the data from the table departments

        ResultSet data = st.executeQuery("select * from departments");

        while(data.next()){

            System.out.printf("%-6d %-15.15s %-8s\n", data.getInt(1), data.getString(2), data.getString(3));

        }

        // Q2: Print the names and salaries of the personnel from sales and IT departments
        // Revers order by salary 
        
        System.out.println("==========================================================================");

        ResultSet data2 = st.executeQuery("select personnel_name, salary from personnel " +
                "where department_id in(10,30) " +
                "order by salary desc;");

        while (data2.next()){
            System.out.printf("%-15.15s %-6d\n",
                    data2.getString(1),
                    data2.getInt(2));
        }

        // Q3: Print all personnel names, department names and salaries 
        // Order by department and salary

        System.out.println("==========================================================================");
        
        ResultSet data3 = st.executeQuery("select department_name, personnel_name, salary " +
                "from departments as D left join personnel as P on D.department_id = P.department_id " +
                "order by department_name desc, P.salary;");

        while (data3.next()){
            // System.out.println(data3.getString(1) + data3.getString(2) + data3.getInt(3));

            System.out.printf("%-10s %-10s %6d\n",data3.getString(1),data3.getString(2),data3.getInt(3));
        }


        // Q4: Print the info of 10 personnel with the highest salary

        System.out.println("==========================================================================");

        ResultSet data4 = st.executeQuery("select p.personnel_name, d.department_name, p.salary " +
                "from departments b left join personnel p on b.department_id=p.department_id order by salary " +
                "desc limit 10");

        while (data4.next()){

            System.out.printf("%-10s %-10s %6d\n", data4.getString(1), data4.getString(2), data4.getInt(3));


        }
        con.close();
        st.close();
        data.close();
        data2.close();
        data3.close();
        data4.close();
    }
}
