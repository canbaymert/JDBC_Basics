package Practices;

import java.sql.*;

public class P1_ReadData {

      //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //hata alanlar Class.forName("com.mysql.jdbc.Driver"); yapistirsin
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "elif.12345");

        Statement st = con.createStatement(); //query calistirmak icin

        // Q1: Talebeler tablesundan tum recordsı listeleyiniz.

      //  ResultSet records = st.executeQuery("select * from talebeler");
      //  while (records.next()){
      //      System.out.printf("%-6d  %-15.15s  %-8s  %-5d\n", records.getInt(1),records.getString(2),
      //      records.getString(3), records.getInt(4));
      //  }

        // Q2: Talebeler tablesunda notları 90 uzeri olan recordsı listeleyiniz.
    //   ResultSet recordsBuyuk90 = st.executeQuery("select * from talebeler where yazili_notu>90");

    //   while(recordsBuyuk90.next()){
    //       System.out.printf("\"%-6d  %-15.15s  %-8d\n", recordsBuyuk90.getInt(1), recordsBuyuk90.getString(2), recordsBuyuk90.getInt(4));

    //   }

        // Q3: Talebeler tablesunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.
   //    ResultSet id124 = st.executeQuery("select * from talebeler where id= 124");
   //    while (id124.next()) {
   //        System.out.printf("%-6s  %-15.15s  %-8s  %-5s\n", id124.getObject(1), id124.getObject(2), id124.getObject(3), id124.getObject(4));

   //    }

        // Q4: Talebeler tablesunda notu 70 ile 90 arasindaki kisilerin namelerini listeleyiniz.

   //     ResultSet not7090 = st.executeQuery("select name, yazili_notu from talebeler where yazili_notu between '70' AND '90'");
   //     while(not7090.next()){
   //         System.out.printf("%-16s  %-16s \n", not7090.getObject(1), not7090.getObject(2));
   //     }

        // Q5: Talebeler tablesunda isminin 2. harfi e olan kisilerin veli_nameleri ile birlikte listeleyiniz.
        ResultSet name2E_veliname = st.executeQuery("select name, veli_name from talebeler where name LIKE '_e%'");
        while (name2E_veliname.next()){
            System.out.printf("%-16s  %-16s \n",name2E_veliname.getObject(1), name2E_veliname.getObject(2));
        }

    }

    }


