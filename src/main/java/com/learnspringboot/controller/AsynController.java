package com.learnspringboot.controller;

import com.learnspringboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/asyn/hello")
    public String hello() {
        asyncService.hello();
        return "success";
    }
}
