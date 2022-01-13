package com.devmountain;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Applesauce {

    public static void main(String[] args) {

        try {

            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setDatabaseName("applesauce");
            Connection connection = ds.getConnection("postgres", "@Nthony77");

            if (connection.isValid(500)) {
                System.out.println("Got a connection using DataSource!");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name FROM foods");

                System.out.println("Here is a list of all foods:");
                while(resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
                System.out.println("That's all, Folks!");
            }

        } catch (Exception e) {
            System.out.println("Exception using DriverManager: " + e.getMessage());
        }
    }


}
