package Practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_DDL {
    /*
                 A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
                    dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.
                       1) execute() metodu
                       2) excuteUpdate() metodu.

                 B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
                      - execute(), Boolean bir deger dondurur.
                      - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
                      - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
                        durumlarda tercih edilmektedir.

                 C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
                    -  bu islemlerde islemden etkilenen satir sayisini dondurur.
                    - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.

                  execute() her turlu SQL kjomutuyla kullanilir .......  DDL ---> False    DML----> True
                  executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini datar
             */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB1?serverTimezone=UTC", "root", "Enter your password here.");

        Statement st = con.createStatement();

        // Q: markalar adında bir table oluşturunuz. marka_id int, marka_name VARCHAR(15), calisan_sayisi int

            String createQuery = "create table markalar(marka_id int, marka_name VARCHAR(15), calisan_sayisi int)";
        //1.yontem : execute () methodu ile
        boolean s1=st.execute(createQuery);
        System.out.println("markalr tablesu olusturuldu " +s1);  //markalr tablesu olusturuldu false


        //2.yontem : executeUpdate() methodu ile

    //    int s2=st.executeUpdate(createQuery);
    //    System.out.println("markalr tablesu olusturuldu " +s2);  //markalr tablesu olusturuldu 0

        // Q: markalar tablesunu siliniz

    //   String dropQuery = "DROP table markalar";
    //   st.execute(dropQuery);
    //   System.out.println("markalar tabllosu silindi...");

        // Q : markalar tablesuna yeni bir sutun {sube_sayisi int} ekleyiniz

    //   String alterQuery = "ALTER table markalar ADD sube_sayisi int";  //default olarak sona ekler
    //   st.executeUpdate(alterQuery);

        // Q : markalar tablesuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun

    //    String alterQuery2 =  "ALTER table markalar ADD sube_sayisi int AFTER marka_id";
    //    st.executeUpdate(alterQuery2);
//
        // Q : markalar tablesunun adini  brands olarak degistiriniz

   //    String alterQuery3 = "Alter table markalar RENAME TO brands";
   //    st.execute(alterQuery3);
   //    System.out.println("table ismi brands olarak degisti..");

        // Q : markalar tablesunda marka_name sutununu name olarak degistiriniz

     //   String alterQuery4 = "Alter table markalar RENAME column marka_name to name";
     //   st.execute(alterQuery4);
     //   System.out.println("sutun ismi degisti..");

        // Q : markalar tablesunda marka_name sutununun data type ini char(20) olarak degistiriniz

        st.execute("alter table markalar modify marka_name char(20)");
        System.out.println("marka ismin data type i degisti");



    }
}