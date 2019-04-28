package cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
    public static void main(String args[]){
        Connection lala=JdbcUtils.getConnection();
        System.out.println(lala);
    }
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
         return  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
