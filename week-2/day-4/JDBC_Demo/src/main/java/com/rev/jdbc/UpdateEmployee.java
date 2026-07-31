package com.rev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/revature_training";
        String username = "revature_user";
        String password = "Revature";

        String sql =
                "UPDATE employees SET salary = ? WHERE emp_id = ?";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, 60000);
            preparedStatement.setInt(2, 4);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " employee updated.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}