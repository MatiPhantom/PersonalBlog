package com.personalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.personalblog.persistence.model.Article;
import com.personalblog.service.ArticleService;
import com.personalblog.service.SessionService;

@Controller
@RequestMapping("/blog/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("/{id}")
    public String index(@PathVariable("id") int id, Model model) {
        if (sessionService.isUserLoggedIn()) {
            model.addAttribute("article", articleService.getArticleById(id));
            return "article/index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/new")
    public String indexNewArticle(Model modelo) {
        modelo.addAttribute("article", new Article());
        return "article/newArticle";
    }

    @PostMapping("/new")
    public String saveArticle(Article article) {
        articleService.registerArticle(article);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String editArticle(@PathVariable("id") int id, Model modelo) {
        modelo.addAttribute("article", articleService.getArticleById(id));
        return "/article/editArticle";
    }

    @PostMapping("/edit/")
    public String updateArticle(Article article, @RequestParam("action") String action) {
        switch (action) {
            case "update":
                articleService.updateArticle(article);
                return "redirect:/blog";

            default:
                return "redirect:/blog/article/delete/" + article.getId();
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") int idArticle) {
        articleService.deleteArticleById(idArticle);
        return "redirect:/blog";
    }

}
