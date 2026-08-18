package com.rev.sp.config.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SymphonyFortune {
    public String getDailyFortune() {
        return "You will have a harmonious day!";
    }
}
