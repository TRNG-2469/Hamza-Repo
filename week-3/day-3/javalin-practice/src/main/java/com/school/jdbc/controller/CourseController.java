package com.school.jdbc.controller;

import com.school.jdbc.model.Course;
import com.school.jdbc.repository.CourseRepository;
import io.javalin.http.Context;

import java.util.List;

public class CourseController {

    private static CourseRepository repo = new CourseRepository();

    // GET /api/courses
    public static void getAllCourses(Context ctx) throws Exception {
        List<Course> courses = repo.getAll();
        ctx.json(courses);
    }

    // GET /api/courses/{id}
    public static void getCourseById(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Course course = repo.getById(id);
        if (course == null) {
            throw new IllegalArgumentException("Course not found with id " + id);
        }
        ctx.json(course);
    }

    // POST /api/courses
    public static void createCourse(Context ctx) throws Exception {
        Course course = ctx.bodyAsClass(Course.class);
        Course created = repo.create(course);
        ctx.status(201);
        ctx.json(created);
    }

    // PUT /api/courses/{id}
    public static void updateCourse(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Course course = ctx.bodyAsClass(Course.class);
        course.setId(id);
        boolean updated = repo.update(course);
        if (!updated) {
            throw new IllegalArgumentException("Course not found with id " + id);
        }
        ctx.json(course);
    }

    // DELETE /api/courses/{id}
    public static void deleteCourse(Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = repo.delete(id);
        if (!deleted) {
            throw new IllegalArgumentException("Course not found with id " + id);
        }
        ctx.status(204);
    }
}
