package com.luv2code.springboot.thymleafdemo.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix=courseCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null)
            return false;
        String upperS=s.toUpperCase();
        String lowerS=s.toLowerCase();
        String lowerCoursePrefix=coursePrefix.toLowerCase();
        if(upperS.startsWith(coursePrefix) || lowerS.startsWith(lowerCoursePrefix))
            return true;
        else
            return false;
    }
}
