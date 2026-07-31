package com.rev.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {

    public static void main(String[] args) {


        String url= "jdbc:postgresql://localhost:5432/revature_training";
        String username = "revature_user";
        String password = "Revature";

        String sql =
                "INSERT INTO employees (emp_id, name, salary) VALUES (?, ?, ?)";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "John");
            preparedStatement.setInt(3, 50000);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " employee inserted.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}