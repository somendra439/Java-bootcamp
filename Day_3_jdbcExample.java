package org.example;

import java.sql.*;

public class Day_3_jdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_sgvu";
        String user = "root";
        String password = "Somu@000";
        try
        {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            // executeQuery is using for select query
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
            {
                System.out.println(rs.getString("username"));
            }
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
