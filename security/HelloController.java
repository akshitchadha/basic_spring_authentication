package com.example.spring_boot_microservice1_course.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Spring Security Rocks";

    }
}
