package com.rev.sp.config.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaApp {
    public static void main(String[] args) {
        // create a container

        // This configuration is coming from an xml file
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext()

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());

    }
}
