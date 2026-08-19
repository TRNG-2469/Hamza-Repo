package com.rev.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myConfiguration.xml");
        Student student = context.getBean("student", Student.class);
        student.setStudentId(1);
        student.setStudentName("Hamza");
        Course course = context.getBean("course", Course.class);
        course.setCourseId(1);
        course.setCourseName("Computer Science");
        course.setDuration("10 Months");
        student.setCourse(course);

        System.out.println(student.getStudentName());
        System.out.println(student.getCourse().getCourseName());
        System.out.println(student.getCourse().getDuration());
    }
}
