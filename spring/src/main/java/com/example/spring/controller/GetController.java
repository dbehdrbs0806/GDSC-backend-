package com.example.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/name")
    public String gethello() {
        return "Flature";
    }

}
