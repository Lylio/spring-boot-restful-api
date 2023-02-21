package com.lylechristine.springbootapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lyle Christine
 */
@RestController
public class GreetingController {

    //localhost:8080/greeting
    //localhost:8080/greeting?name=Alice
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}
