package com.school.jdbc.repository;

import com.school.jdbc.model.Enrollment;
import com.school.jdbc.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    public List<Enrollment> getAll() throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollments ORDER BY id";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            enrollments.add(buildEnrollment(rs));
        }
        conn.close();
        return enrollments;
    }

    public Enrollment getById(int id) throws SQLException {
        String sql = "SELECT * FROM enrollments WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Enrollment enrollment = null;
        if (rs.next()) {
            enrollment = buildEnrollment(rs);
        }
        conn.close();
        return enrollment;
    }

    public Enrollment create(Enrollment enrollment) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id, grade) VALUES (?, ?, ?)";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, enrollment.getStudentId());
        stmt.setInt(2, enrollment.getCourseId());
        stmt.setString(3, enrollment.getGrade());
        stmt.executeUpdate();

        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            enrollment.setId(keys.getInt(1));
        }
        conn.close();
        return enrollment;
    }

    public boolean update(Enrollment enrollment) throws SQLException {
        String sql = "UPDATE enrollments SET student_id = ?, course_id = ?, grade = ? WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, enrollment.getStudentId());
        stmt.setInt(2, enrollment.getCourseId());
        stmt.setString(3, enrollment.getGrade());
        stmt.setInt(4, enrollment.getId());
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    private Enrollment buildEnrollment(ResultSet rs) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(rs.getInt("id"));
        enrollment.setStudentId(rs.getInt("student_id"));
        enrollment.setCourseId(rs.getInt("course_id"));
        enrollment.setGrade(rs.getString("grade"));
        return enrollment;
    }
}