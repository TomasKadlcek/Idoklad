package com.lemony.upgatesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("upgates")
public class UpgatesController {

    @GetMapping
    public String getConnection() {

        return "test";
    }

}
