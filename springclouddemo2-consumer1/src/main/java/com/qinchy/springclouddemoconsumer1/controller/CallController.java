package com.qinchy.springclouddemoconsumer1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {

    @GetMapping("/call")
    public String call(){
        return "";
    }
}
