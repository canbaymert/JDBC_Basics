import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q1: Urunler adında bir tablo olusturalım (id int, name varchar(10), fiyat int)
        //st.execute("create table urunler (id int, name varchar(10), fiyat int)");

        // Q2: urunler tablosuna aşağıdaki dataleri toplu bir şekilde etkileyin
        // Çok miktarda kayıt eklemek için PreparedStatement metodu kullanılır.
        // 1) data girişine uygun bir POJO (Plain Old Java Object) class oluşturulur
        // 2) POJO class ta nesneleri saklayacak bir collection oluşturulur
        // 3) Bir döngü ile kayıtlar eklenir.

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(101,"Laptop",6500));
        kayitlar.add(new Urun(102,"PC",4500));
        kayitlar.add(new Urun(103,"Telefon",4500));
        kayitlar.add(new Urun(104,"Anakart",1500));
        kayitlar.add(new Urun(105,"Klavye",200));
        kayitlar.add(new Urun(106,"Fare",100));

        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?, ?, ?)");
        for(Urun each:kayitlar){
            tablo.setInt(1, each.getId());
            tablo.setString(2, each.getname());
            tablo.setDouble(3, each.getFiyat());

            tablo.addBatch();   //Butun dataleri bir araya getirir
        }
        tablo.executeBatch();
        System.out.println("dataler Database'e eklendi");

        con.close();
        st.close();
        tablo.close();

    }
}