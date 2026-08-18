package com.rev.sp.config.java;

public class CricketCoach {

    /*
    CricketFortune is a dependency of CricketCoach
    Here we are injecting that dependency using the Constructor Injection

     */
    CricketFortune cricketFortune;
    public CricketCoach(CricketFortune cricketFortune) {
        this.cricketFortune = cricketFortune;
    }

    public String getDailyWorkout() {
        return "Practice Fielding...";
    }

    public String getDailyFortune() {
        return cricketFortune.getDailyFortune();
    }
}
