package com.example.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetApi {
    @GetMapping(value = "/name")
    public String getName() {
        return "Flature";
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getName2(@PathVariable("variable") String var) {
        return var;
    }
    @GetMapping(value="/request1")
    public String getName3(@RequestParam String name) {
        return name;
    }
}

