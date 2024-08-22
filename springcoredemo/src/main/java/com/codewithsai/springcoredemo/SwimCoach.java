package com.codewithsai.springcoredemo;

public class SwimCoach implements  Coach{
    @Override
    public String getDailyWorkOut() {
        return "Swim 1000 m daily";
    }
}
