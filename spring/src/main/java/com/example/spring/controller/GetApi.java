package com.example.spring.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/get-api")      // 앞의 http 의 url 부분을 작성하는 어노테이션
public class GetApi {

    //http://localhost:8080/api/v1/get-api/variable1/{String 변수 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String variable) {
        return variable;
    }
}
// @PathVariable 어노테이션은 매개변수로 받은 URL을 매개변수로 사용하고 싶으면 이렇게 해야함
