package com.rev.sp.boot.rest.repository;

import com.rev.sp.boot.rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    List<Student> findByCourse(String course);
    List<Student> findByAge(int age);


}
