package Practices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class P5_CRUD {
    // Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir.
    // PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir.
    // ResultSet tum sonucları bellekte tutuyor..  ama guvenli degil..banka hesaplarını dusunun..siber saldırıya ugrasa..
    // bu yuzden database in guvrnligi acisindan PreparedStatement onemlidir..
    // Bunun icin;
    // 	1) data girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
    // 	2) POJO Class nesnelerini saklayacak bir collection olusturulur
    // 	3) bir dongu ile records eklenir.

    // PreparedStatement hizli ve guvenli yontem, bu yontemle cozecegiz
    // POJO class : plain old java object class, bu class calistirilmaz main i yok..
    // bu class private degisken + constructor() + getter() + setter() ve toString() ler iceren class


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.lang.Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC";
        Connection con = DriverManager.getConnection(url, "root", "Enter your password here.");  //database baglantisi icin

        Statement st = con.createStatement();  //query calistirmak icin

        // Q: Dersler adında bir table olusturalım (id int, class_name varchar(15), education_period int)
        String createQuery = "create table dersler (id int, class_name VARCHAR(15), education_period_gun int)";

        st.execute(createQuery);
        System.out.println("table olusturuldu..");

        //Not : Ders diye bir pojo class olustururuz,
        // id(int), class_name(String), education_period(int) instance variable ları olusturup,
        // Generate den constructor , getter setter ve toString() methodlari cagiririz

        List<POJO_Class> dersler = new ArrayList<>();
        dersler.add(new POJO_Class(100, "Java",50));
        dersler.add(new POJO_Class(101, "SQL",10));
        dersler.add(new POJO_Class(102, "JDBC",2));
        dersler.add(new POJO_Class(103, "APi",12));
        dersler.add(new POJO_Class(104, "JENKİNS",1));
        dersler.add(new POJO_Class(105, "Selenium",25));
        dersler.add(new POJO_Class(106, "Appium",10));
        dersler.add(new POJO_Class(107, "SDLC",10));

        PreparedStatement table = con.prepareStatement("INSERT INTO dersler VALUES (?,?,?)");  //hangi formatta ise table o dataleri dusunerek value ları yazariz

        for (POJO_Class d : dersler){
            table.setInt(1, d.getId());
            table.setString(2, d.getclass_name());
            table.setInt(3, d.geteducation_period());

            table.addBatch();
        }

        table.executeBatch();


        System.out.println("Hersey Tamam");
        //mySql de derslerin hizasindaki son simgeye basilirsa table SQL de gorunur..
    }

}
