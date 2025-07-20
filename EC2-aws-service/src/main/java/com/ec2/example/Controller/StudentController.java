package com.ec2.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/vivek")
    public String sayHello(@RequestParam(defaultValue = "siya ram") String name) {
        return "Hello, My " + name + "i am full stack developer";
    }

    @GetMapping("/vikash")
    public String sayHello1(@RequestParam(defaultValue = "siya ram") String name) {
        return "Hello, " + name;
    }

    @GetMapping("/kuber")
    public String sayHello2(@RequestParam(defaultValue = "siya ram") String name) {
        return "This is my father";
    }
}