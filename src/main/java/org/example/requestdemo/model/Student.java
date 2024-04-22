package org.example.requestdemo.model;

import java.util.List;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int age;
    private boolean isStudent;
    private double gpa;
    
    List<Address> addresses;
}
