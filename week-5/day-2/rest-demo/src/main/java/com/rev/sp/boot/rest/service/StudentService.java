package com.rev.sp.boot.rest.service;

import com.rev.sp.boot.rest.exceptions.StudentNotFoundException;
import com.rev.sp.boot.rest.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    public StudentService(){
        students.add(new Student(1, "John Doe", "john.doe@example.com", "Computer Science"));
        students.add(new Student(2, "Jane Smith", "jane.smith@example.com", "Mathematics"));
        students.add(new Student(3, "Alice Johnson", "alice.johnson@example.com", "Physics"));
    }
    public List<Student> getAllStudents() {
        return students;
    }
    public Student getStudentById(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new StudentNotFoundException(id);
    }
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setCourse(updatedStudent.getCourse());
                return updatedStudent;
            }
        }
        return null;
    }
    public String deleteStudent(@PathVariable int id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == id) {
                students.remove(i);
                return "Student with ID " + id + " deleted.";
            }
        }
        return "Student with ID " + id + " not found.";
    }
}
