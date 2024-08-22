package com.codewithsai.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    private Coach newCoach;

//    DemoController(@Qualifier("cricketCoach") Coach c){
//        coach=c;
//        newCoach=c;
//        System.out.println("single ton scope:"+(coach==(newCoach)));
//        System.out.println(getClass().getSimpleName());
//    }

    DemoController(){
        System.out.println(getClass().getSimpleName());
    }
    //constructor injection
/*
    DemoController(Coach c){
        coach=c;
    }
*/

    //setter injection
    //@Qualifier is used to specify which coach implementations you need ,if there are more implementation
    //try by removing @Qualifier("basketballCoach") ,apps works as @Primary annotation is kept for CricketCoach
    @Autowired
    public void setCoach(@Qualifier("aquatic") Coach c,
                         @Qualifier("cricketCoach") Coach ac){
        coach=c;
        newCoach=ac;

    }

    @GetMapping("/check")
    public String checkScope(){
        return ("check scope of coach==newCoach  "+(coach==(newCoach)));
    }

    //endpoint /workout
    @GetMapping("/workout")
    public String getDailyWork(){
        return coach.getDailyWorkOut();
    }

    @GetMapping("/")
    public String start(){
        return "Server is running";
    }
}
