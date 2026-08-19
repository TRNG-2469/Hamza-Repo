package com.rev.sp.boot.rest.exceptions;

import org.springframework.web.bind.annotation.PathVariable;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(@PathVariable int id) {
        super("Student with ID " + id + " not found");
    }
}
