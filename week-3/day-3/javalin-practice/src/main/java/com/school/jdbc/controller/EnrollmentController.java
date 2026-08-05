package com.school.jdbc.controller;

import com.school.jdbc.model.Enrollment;
import com.school.jdbc.repository.EnrollmentRepository;
import io.javalin.http.Context;

import java.util.List;

public class EnrollmentController {

    private static EnrollmentRepository repo = new EnrollmentRepository();

    // GET /api/enrollments
    public static void getAllEnrollments(Context ctx) throws Exception {
        List<Enrollment> enrollments = repo.getAll();
        ctx.json(enrollments);
    }

    // GET /api/enrollments/{id}
    public static void getEnrollmentById(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Enrollment enrollment = repo.getById(id);
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment not found with id " + id);
        }
        ctx.json(enrollment);
    }

    // POST /api/enrollments  (links a student to a course)
    public static void createEnrollment(Context ctx) throws Exception {
        Enrollment enrollment = ctx.bodyAsClass(Enrollment.class);
        Enrollment created = repo.create(enrollment);
        ctx.status(201);
        ctx.json(created);
    }

    // PUT /api/enrollments/{id}
    public static void updateEnrollment(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Enrollment enrollment = ctx.bodyAsClass(Enrollment.class);
        enrollment.setId(id);
        boolean updated = repo.update(enrollment);
        if (!updated) {
            throw new IllegalArgumentException("Enrollment not found with id " + id);
        }
        ctx.json(enrollment);
    }

    // DELETE /api/enrollments/{id}
    public static void deleteEnrollment(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = repo.delete(id);
        if (!deleted) {
            throw new IllegalArgumentException("Enrollment not found with id " + id);
        }
        ctx.status(204);
    }
}
