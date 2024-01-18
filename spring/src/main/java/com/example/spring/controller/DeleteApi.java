package com.example.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteApi {
    @DeleteMapping(value = "/request1")
    public String getDelete(@RequestParam String email) {return "e-mail: " + email; }
}
