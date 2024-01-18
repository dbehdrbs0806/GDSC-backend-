package com.example.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
