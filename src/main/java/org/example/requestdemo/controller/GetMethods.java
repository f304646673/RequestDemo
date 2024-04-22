package org.example.requestdemo.controller;

import org.example.requestdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@Tag(name = "getmethods", description = "Different types of GET methods")
@RestController
@RequestMapping("/getmethods")
public class GetMethods {

    @Operation(summary = "Get string value", description = "Returns a string value")
    @GetMapping("/string")
    public String getString() {
        return "Hello, World!";
    }

    @Operation(summary = "Get integer value", description = "Returns an integer value")
    @RequestMapping(path="/int", method=RequestMethod.GET)
    public int getInt() {
        return 123;
    }

    @Operation(summary = "Get double value", description = "Returns a double value")
    @Parameters({
        @Parameter(name = "value", description = "Double value", required = true)
    })
    @GetMapping(path="/double")
    public double getDouble() {
        return 3.14;
    }

    @Operation(summary = "Get long value", description = "Returns a long value")
    @Parameters({
        @Parameter(name = "value", description = "Long value", required = true)
    })
    @GetMapping(path="/long")
    public long getLong(long value) {
        return value;
    }

    @Operation(summary = "Get long value with default", description = "Returns a long value with default")
    @Parameters({
        @Parameter(name = "value", description = "Long value with default", required = false)
    })
    @GetMapping(path="/longdefault")
    public long getLongDefault(@RequestParam(defaultValue = "123") long value) {
        return value;
    }

    @Operation(summary = "Get boolean value", description = "Returns a boolean value")
    @Parameters({
        @Parameter(name = "value", description = "Boolean value")
    })
    @GetMapping(path="/boolean")
    public boolean getBoolean(@RequestParam(required = false, defaultValue = "true") boolean value) {
        return value;
    }

    @Operation(summary = "Get object value", description = "Returns an object value")
    @GetMapping(path="/object")
    public Student getObject(@RequestParam(name = "name") String studentName) {
        Student student = new Student();
        student.setName(studentName);
        student.setAge(20);
        student.setStudent(true);
        student.setGpa(3.5);
        return student;
    }



}
