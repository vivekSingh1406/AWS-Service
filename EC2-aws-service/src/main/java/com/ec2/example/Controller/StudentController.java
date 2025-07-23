package com.ec2.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/hello")
    public String greet(@RequestParam(defaultValue = "Siya Ram") String name) {
        return "Hello, " + name + "! I am a full stack developer.";
    }

    @GetMapping("/greet")
    public String simpleGreet(@RequestParam(defaultValue = "Siya Ram") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/father")
    public String fatherMessage() {
        return "This is my father.";
    }
}
