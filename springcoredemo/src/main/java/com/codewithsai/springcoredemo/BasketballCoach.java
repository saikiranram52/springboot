package com.codewithsai.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements  Coach{
    BasketballCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Jump and run for 10 mins";
    }
}
