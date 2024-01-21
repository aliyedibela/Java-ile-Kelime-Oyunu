package com.kelime.oyunu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static Connection con;

    public static void dbConnect() {
        if(!baglandiMi()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kelime_oyunu", "root", "root");
            } catch (Exception e) {
                System.out.println("Hata : " + e);
            }
        }
    }

    public static Connection getCon(){
        return con;
    }

    public static boolean baglandiMi(){
        return con != null;
    }
}
