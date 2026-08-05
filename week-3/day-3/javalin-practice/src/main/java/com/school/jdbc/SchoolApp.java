package com.school.jdbc;

import com.school.jdbc.controller.CourseController;
import com.school.jdbc.controller.EnrollmentController;
import com.school.jdbc.controller.StudentController;
import com.school.jdbc.exception.ErrorResponse;
import io.javalin.Javalin;


public class SchoolApp {
    public static void main(String[] args) {

        // Initialize and start Javalin
        Javalin app = Javalin.create().start(8080);

        // ---------- Students ----------
        // 1. Get all students
        app.get("/api/students", StudentController::getAllStudents);
        // 2. Get one student by id
        app.get("/api/students/{id}", StudentController::getStudentById);
        // 3. Create a student
        app.post("/api/students", StudentController::createStudent);
        // 4. Update a student
        app.put("/api/students/{id}", StudentController::updateStudent);
        // 5. Delete a student by id
        app.delete("/api/students/{id}", StudentController::deleteStudent);

        // ---------- Courses ----------
        app.get("/api/courses", CourseController::getAllCourses);
        app.get("/api/courses/{id}", CourseController::getCourseById);
        app.post("/api/courses", CourseController::createCourse);
        app.put("/api/courses/{id}", CourseController::updateCourse);
        app.delete("/api/courses/{id}", CourseController::deleteCourse);

        // ---------- Enrollments (junction table: student <-> course) ----------
        app.get("/api/enrollments", EnrollmentController::getAllEnrollments);
        app.get("/api/enrollments/{id}", EnrollmentController::getEnrollmentById);
        // Enroll a student in a course: body { "studentId": 1, "courseId": 1 }
        app.post("/api/enrollments", EnrollmentController::createEnrollment);
        app.put("/api/enrollments/{id}", EnrollmentController::updateEnrollment);
        app.delete("/api/enrollments/{id}", EnrollmentController::deleteEnrollment);

        // Centralized Exception Handling
        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
            ctx.json(new ErrorResponse(e.getMessage()));
        });

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.json(new ErrorResponse("An unexpected Server error occurred"));
        });
    }
}
