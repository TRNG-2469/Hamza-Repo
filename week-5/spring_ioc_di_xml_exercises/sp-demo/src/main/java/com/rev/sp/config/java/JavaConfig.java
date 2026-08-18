package com.rev.sp.config.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    //<bean id = "cricketCoach" class="com.rev.sp.config.java.CricketCoach"/>
    @Bean
    public CricketFortune cricketFortune() {
        return new CricketFortune();
    }

    @Bean
    public CricketCoach cricketCoach() {
        return new CricketCoach(cricketFortune());
    }

}
