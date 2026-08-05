package com.school.jdbc.controller;


import com.school.jdbc.model.Student;
import com.school.jdbc.repository.StudentRepository;
import io.javalin.http.Context;

import java.util.List;

public class StudentController {

    private static StudentRepository repo = new StudentRepository();

    // GET /api/students
    public static void getAllStudents(Context ctx) throws Exception {
        List<Student> students = repo.getAll();
        ctx.json(students);
    }

    // GET /api/students/{id}
    public static void getStudentById(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Student student = repo.getById(id);
        if (student == null) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        ctx.json(student);
    }

    // POST /api/students
    public static void createStudent(Context ctx) throws Exception {
        Student student = ctx.bodyAsClass(Student.class);
        Student created = repo.create(student);
        ctx.status(201);
        ctx.json(created);
    }

    // PUT /api/students/{id}
    public static void updateStudent(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Student student = ctx.bodyAsClass(Student.class);
        student.setId(id);
        boolean updated = repo.update(student);
        if (!updated) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        ctx.json(student);
    }

    // DELETE /api/students/{id}
    public static void deleteStudent(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = repo.delete(id);
        if (!deleted) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        ctx.status(204);
    }
}
