package com.personalblog.controller;


import com.personalblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("articles", articleService.getAllArticles());
        return "blog/index";
    }



}
