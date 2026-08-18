package com.rev.sp.config.annotation;

import org.springframework.stereotype.Component;

@Component
public class MusicCoach { //musicCoach is a bean managed by Spring
    //@Autowired are used for Setter Injection
    //@Inject is used for different frameworks

    // This is Constructor Injection
    SymphonyFortune symphonyFortune;

    public MusicCoach(SymphonyFortune symphonyFortune) {
        this.symphonyFortune = symphonyFortune;
    }

    public String getDailyWorkout(){
        return "Practice your scales for 30 minutes";
    }

    public String getDailyFortune(){
        return symphonyFortune.getDailyFortune();
    }




}
