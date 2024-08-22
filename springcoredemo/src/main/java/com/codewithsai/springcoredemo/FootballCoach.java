package com.codewithsai.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements  Coach{
    FootballCoach(){
        System.out.println(getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "run to and fro of the ground for 1 hour";
    }
}
