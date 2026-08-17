package com.rev.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.getSalary());
        System.out.println(employee.getAddress());

    }
}
