package com.personalblog.controller;


import com.personalblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BlogController {
    @Autowired
    private ArticleService articleService;

    public String index(Model model){
        model.addAttribute("articles", articleService.getAllArticles());
        return "blog/index";
    }



}
