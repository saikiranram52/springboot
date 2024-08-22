package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }


    @PostMapping("/processForm")
    public String processFormValidation(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult){
        System.out.println(bindingResult.toString());
        System.out.println("\n\n\n");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        else {
            return "customer-validated-form";
        }
    }

    @GetMapping("variable-expression")
    public String variableExpression(Model model){
        model.addAttribute("customer","saikiran");
        return "variable-expression";
    }

    @GetMapping("selection-expression")
    public String selectionExpression(Model model){
        Customer customer=new Customer();
        customer.setFirstName("sai");
        customer.setLastName("kiran");
        model.addAttribute("customer",customer);
        return "selection-expression";
    }

    @GetMapping("message-expression")
    public String messageExpression(Model model){
        return "message-expression";
    }

}
