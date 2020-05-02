package com.qinchy.springclouddemoprovider1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello," + name;
    }
}
