package com.codewithsai.springcoredemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Lazy
//@Scope("prototype")
//or
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements  Coach{

    CricketCoach(){
        System.out.println(getClass().getSimpleName());
    }

    //define our init method
    @PostConstruct
    public void doPostConstruct(){
        System.out.println("Post contruct is called,after the CricketCoach is called");
    }

    @PreDestroy
    public void doPreDestroy(){
        System.out.println("Destroy is called after stop our application");
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 30 mins!!";
    }
}
