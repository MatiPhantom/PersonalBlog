package com.personalblog.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.personalblog.persistence.model.Article;
import com.personalblog.persistence.storage.UtilArticleStorage;

@Repository
public class ArticleDAO implements DAO<Article> {

    private final List<Article> articles = UtilArticleStorage.load();

    public List<Article> findAll() {
        return articles;
    }

    public Article findById(int id) {
        return articles.stream()
                .filter(article -> article.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Article article) {
        articles.add(article);
        UtilArticleStorage.save(articles);
    }

    public void deleteById(int id) {
        articles.removeIf(article -> article.getId() == id);
        UtilArticleStorage.save(articles);
    }

    public void update(Article article) {
        loop: for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()) {
                articles.set(i, article);
                break loop;
            }
        }
        UtilArticleStorage.save(articles);
    }

}
