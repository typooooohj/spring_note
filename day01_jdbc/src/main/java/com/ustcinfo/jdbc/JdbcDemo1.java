package com.ustcinfo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easy","root","admin");
            PreparedStatement ps = conn.prepareStatement(" select * from account");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
