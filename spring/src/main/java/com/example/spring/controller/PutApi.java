package com.example.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/put-api")
public class PutApi {
    @PutMapping("/member3")
    public ResponseEntity<String> updateMember3(@RequestBody Member member) {
        return new ResponseEntity<>("PutMapping ex", HttpStatus.ACCEPTED);
    }
}