public class Query10 extends DatabaseUtilty{

    public static void main(String[] args) {

        createConnection();
        String query = "select * from students";
        System.out.println("Column names : " + getColumnNames(query));
        System.out.println("Student Number : " + getColumnData(query, "student_no"));
        System.out.println("Student Name : " + getColumnData(query, "student_name"));
        System.out.println("Class : " + getColumnData(query, "class"));
        System.out.println("Sex : " + getColumnData(query, "sex"));


    }
}