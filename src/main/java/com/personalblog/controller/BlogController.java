package com.personalblog.controller;

import com.personalblog.service.ArticleService;
import com.personalblog.service.SessionService;

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

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public String index(Model model) {
        if (sessionService.isUserLoggedIn()) {
            model.addAttribute("articles", articleService.getAllArticles());
            model.addAttribute("userLoged", sessionService.getUserLoged());
            return "blog/index";
        } else {
            return "redirect:/login";
        }

    }

}
