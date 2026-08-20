package com.rev.sp.boot.rest.service;

import com.rev.sp.boot.rest.exceptions.StudentNotFoundException;
import com.rev.sp.boot.rest.model.Student;
import com.rev.sp.boot.rest.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(@PathVariable int id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());

        return studentRepository.save(existingStudent);

    }
    public String deleteStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
        studentRepository.delete(student);
        return "Student deleted successfully";
    }

    }

