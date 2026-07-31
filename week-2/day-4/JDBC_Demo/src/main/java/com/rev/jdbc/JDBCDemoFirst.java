package com.rev.jdbc;

import java.sql.*;

public class JDBCDemoFirst {
    public static void main(String[] args) {
        //STEP 1 - Load the driver(Optinal)
        //try {
        //   Class.forName("org.postgresql.Driver");
        //STEP 2 - Create a connection
        try {
            // PostgreSQL JDBC uses a Type 4 driver: a pure Java driver that connects directly to PostgreSQL.
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/revature_training",
                    "revature_user",
                    "Revature");

            //STEP 3 - Create Statement Object

            Statement statement = connection.createStatement();
            //STEP 4 - Execute Query and collect the result in ResultSet
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            //STEP 5 - Iterate over and process resultset
            while (resultSet.next()){
                System.out.println(resultSet.getInt("emp_id") + " " + resultSet.getString("name") + " " + resultSet.getInt("salary"));
            }
            //STEP 6 - Close the connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //} catch (ClassNotFoundException e) {
        //     throw new RuntimeException(e);
        //}

    }
}