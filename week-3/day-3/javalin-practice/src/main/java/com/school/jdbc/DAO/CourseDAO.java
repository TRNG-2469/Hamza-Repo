package com.school.jdbc.DAO;

import com.school.jdbc.model.Course;
import com.school.jdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Talks to the "courses" table using JDBC.
public class CourseDAO {

    public List<Course> getAll() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses ORDER BY id";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            courses.add(buildCourse(rs));
        }
        conn.close();
        return courses;
    }

    public Course getById(int id) throws SQLException {
        String sql = "SELECT * FROM courses WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Course course = null;
        if (rs.next()) {
            course = buildCourse(rs);
        }
        conn.close();
        return course;
    }

    public Course create(Course course) throws SQLException {
        String sql = "INSERT INTO courses (code, title, credits) VALUES (?, ?, ?)";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, course.getCode());
        stmt.setString(2, course.getTitle());
        stmt.setInt(3, course.getCredits());
        stmt.executeUpdate();

        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            course.setId(keys.getInt(1));
        }
        conn.close();
        return course;
    }

    public boolean update(Course course) throws SQLException {
        String sql = "UPDATE courses SET code = ?, title = ?, credits = ? WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, course.getCode());
        stmt.setString(2, course.getTitle());
        stmt.setInt(3, course.getCredits());
        stmt.setInt(4, course.getId());
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?";

        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        conn.close();
        return rows > 0;
    }

    private Course buildCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("id"));
        course.setCode(rs.getString("code"));
        course.setTitle(rs.getString("title"));
        course.setCredits(rs.getInt("credits"));
        return course;
    }
}
