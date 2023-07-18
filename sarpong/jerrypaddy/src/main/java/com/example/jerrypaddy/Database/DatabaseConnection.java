package com.example.jerrypaddy.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public void createConnection1(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from vendors");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(resultSet.getString("name") + "\t" + resultSet.getInt("age"));
            }

            }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void createConnection2(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            statement.execute("insert into beverages (name, number_in_package, cost_per_item, selling_price) values (\"This Way\", 23, 67.33, 90.77)");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
