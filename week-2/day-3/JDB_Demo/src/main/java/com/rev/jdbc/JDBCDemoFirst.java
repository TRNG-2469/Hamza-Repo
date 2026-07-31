package com.rev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemoFirst {
    public static void main(String[] args) {

        // Step 1 - Load the Driver (Optional because new Java JDKs you don't need it)
        try {
            Class.forName("org.postgresql.Driver");
            //Step 2 - Create a connection

            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://local/mydb",
                    "username", "password");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
