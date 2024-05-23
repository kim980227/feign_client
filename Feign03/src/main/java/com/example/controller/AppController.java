package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bpp1")
class AppController1 {

    @Autowired
    RestTemplate rt;

    @GetMapping
    String f1(){
        System.out.println("cpp1");
        return "cpp1";
    }
}


@RestController
@RequestMapping("/bpp2")
class AppController2 {

    @Autowired
    RestTemplate rt;

    @GetMapping
    String f1(){
        System.out.println("cpp2");
        return "cpp2";
    }
}


@RestController
@RequestMapping("/bpp3")
class AppController3 {

    @Autowired
    RestTemplate rt;

    @GetMapping("/{num}")
    String f1(@PathVariable Integer num){
        System.out.println("cpp3");
        return "cpp3";
    }
}