package com.rev.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = context.getBean("car",  Car.class);
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Car Price: " + car.getPrice());
        System.out.println("Engine: " + car.getModel());
        System.out.println("Horsepower: " + car.getHorsePower());
    }
}
