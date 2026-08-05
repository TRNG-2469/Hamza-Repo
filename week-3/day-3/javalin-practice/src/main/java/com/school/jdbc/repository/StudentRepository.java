package com.school.jdbc.repository;

import com.school.jdbc.model.Student;
import com.school.jdbc.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            students.add(buildStudent(rs));
        }
        conn.close();
        return students;
    }

    public Student getById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Student student = null;
        if (rs.next()) {
            student = buildStudent(rs);
        }
        conn.close();
        return student;
    }

    public Student create(Student student) throws SQLException {
        String sql = "INSERT INTO students (first_name, last_name, email) VALUES (?, ?, ?)";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setString(3, student.getEmail());
        stmt.executeUpdate();

        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            student.setId(keys.getInt(1));
        }
        conn.close();
        return student;
    }

    public boolean update(Student student) throws SQLException {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ? WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setString(3, student.getEmail());
        stmt.setInt(4, student.getId());
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    // Turns one row of the result set into a Student object.
    private Student buildStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setEmail(rs.getString("email"));
        return student;
    }
}
