package com.personalblog.controller;


import org.springframework.stereotype.Controller;

@Controller
public class BlogController {

    public String index(){
        return "blog/index";
    }
}
