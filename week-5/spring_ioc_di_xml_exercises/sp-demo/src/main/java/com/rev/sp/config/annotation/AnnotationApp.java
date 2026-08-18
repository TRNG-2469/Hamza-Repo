package com.rev.sp.config.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        MusicCoach musicCoach =  context.getBean(MusicCoach.class);
        System.out.println(musicCoach.getDailyWorkout());
        System.out.println(musicCoach.getDailyFortune());
    }


}
