package com.codewithsai.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "fancy-login";
    }
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    } @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
    @GetMapping("/accessdenied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
