package com.luv2code.springboot.thymleafdemo.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy =CustomerConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
     String value() default "LUV";
     String message() default "must start with the LUV";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
