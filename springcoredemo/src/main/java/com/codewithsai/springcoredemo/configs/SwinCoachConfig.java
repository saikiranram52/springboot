package com.codewithsai.springcoredemo.configs;

import com.codewithsai.springcoredemo.Coach;
import com.codewithsai.springcoredemo.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwinCoachConfig {

    //Define bean with custom id
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
