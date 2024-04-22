package org.example.requestdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.example.requestdemo.model.Address;
import org.example.requestdemo.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "responses", description = "Different types of responses")
@RestController
@RequestMapping("/responses")
public class Responses {

    @GetMapping("/string")
    public String getString() {
        return "Hello, World!";
    }

    @GetMapping("/int")
    public int getInt() {
        return 123;
    }

    @GetMapping("/double")
    public double getDouble() {
        return 3.14;
    }

    @GetMapping("/boolean")
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/object")
    public Student getObject() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(20);
        student.setStudent(true);
        student.setGpa(3.5);
        return student;
    }

    @GetMapping("/array")
    public Student[] getArray() {
        Student[] students = new Student[2];
        students[0] = new Student();
        students[0].setName("John Doe");
        students[0].setAge(20);
        students[0].setStudent(true);
        students[0].setGpa(3.5);
        students[1] = new Student();
        students[1].setName("Jane Doe");
        students[1].setAge(21);
        students[1].setStudent(false);
        students[1].setGpa(3.6);
        return students;
    }

    @GetMapping("/list")
    public List<Student> getList() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(20);
        student1.setStudent(true);
        student1.setGpa(3.5);
        students.add(student1);
        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setAge(21);
        student2.setStudent(false);
        student2.setGpa(3.6);
        students.add(student2);
        return students;
    }

    @GetMapping("/map")
    public Map<String, Student> getMap() {
        Map<String, Student> students = new HashMap<>();
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(20);
        student1.setStudent(true);
        student1.setGpa(3.5);
        students.put("John", student1);
        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setAge(21);
        student2.setStudent(false);
        student2.setGpa(3.6);
        students.put("Jane", student2);
        return students;
    }

    @GetMapping("/set")
    public Set<Student> getSet() {
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setName("John Doe");
        student1.setAge(20);
        student1.setStudent(true);
        student1.setGpa(3.5);
        students.add(student1);
        Student student2 = new Student();
        student2.setName("Jane Doe");
        student2.setAge(21);
        student2.setStudent(false);
        student2.setGpa(3.6);
        students.add(student2);
        return students;
    }

    @GetMapping("/void")
    public void getVoid() {
        System.out.println("This is a void method");
    }

    @GetMapping("/null")
    public String getNull() {
        return null;
    }

    @GetMapping("/json")
    public Student getJson() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(20);
        student.setStudent(true);
        student.setGpa(3.5);

        List<Address> addresses = new ArrayList<>();
        Address address1 = new Address();
        address1.setStreet("123 Main St");
        address1.setCity("Springfield");
        address1.setState("IL");
        address1.setZip("62701");
        addresses.add(address1);
        Address address2 = new Address();
        address2.setStreet("456 Elm St");
        address2.setCity("Springfield");
        address2.setState("IL");
        address2.setZip("62702");
        addresses.add(address2);

        student.setAddresses(addresses);

        return student;
    }
    
    @GetMapping(path="/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Student getXml() {
        Student student = new Student();
        student.setName("Jane Doe");
        student.setAge(21);
        student.setStudent(false);
        student.setGpa(3.6);

        List<Address> addresses = new ArrayList<>();
        Address address1 = new Address();
        address1.setStreet("123 Main St");
        address1.setCity("Springfield");
        address1.setState("IL");
        address1.setZip("62701");
        addresses.add(address1);
        Address address2 = new Address();
        address2.setStreet("456 Elm St");
        address2.setCity("Springfield");
        address2.setState("IL");
        address2.setZip("62702");
        addresses.add(address2);

        student.setAddresses(addresses);

        return student;
    }

    @GetMapping("/error")
    public String getError() {
        throw new RuntimeException("This is an error message");
    }
    
    @GetMapping("/exception")
    public String getException() {
        throw new IllegalArgumentException("This is an exception message");
    }
}
