package com.luv2code.springboot.thymleafdemo.model;

import com.luv2code.springboot.thymleafdemo.annotation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
//(value="LUV",message = "should starts with LUV")
    @CourseCode
    private String courseCode;

    @NotNull(message = "lastName is Required")
    @Size(min = 1,message = "is Required")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 characters/digits are requried")
    private String postalCode;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull(message = "is Required")
    @Min(value=1,message = "should be greater than or equal to zero")
    @Max(value=10,message = "should be less than or equal to 10")
    private Integer freePass;

    public Integer getFreePass() {
        return freePass;
    }
    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }
}
