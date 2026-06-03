package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //decorating the class as route handler
@RequestMapping("/api") //the handler base route i.e all request to this path will come here
public class DemoRestController {


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world! from Faruq";
    }
}

