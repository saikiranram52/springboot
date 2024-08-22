package com.luv2code.springboot.thymleafdemo.controller;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Controller
public class ThymleafDemo {
    private int id;
    private String name;
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate",new java.util.Date());
        model.addAttribute("header","THYMELEAF");
        return "helloworld";
    }
}
