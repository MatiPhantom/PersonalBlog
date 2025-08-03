package com.personalblog.service;

import com.personalblog.persistence.dao.ArticleDAO;
import com.personalblog.persistence.dao.DAO;
import com.personalblog.persistence.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArticleService")
public class ArticleService {

    @Autowired
    private DAO<Article> articleDAO;

    public void registerArticle(Article article) {
        articleDAO.save(article);
    }

    public List<Article> getAllArticles() {

        return articleDAO.findAll();
    }

    public Article getArticleById(int id) {
        return articleDAO.findById(id);
    }

    public void updateArticle(Article article) {
        articleDAO.update(article);
    }

    public void deleteArticleById(int id) {
        articleDAO.deleteById(id);
    }

}
