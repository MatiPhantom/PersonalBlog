package com.personalblog.persistence.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.personalblog.persistence.model.Article;

@Repository
public class ArticleDAO {

    private List<Article> articles;

    public List<Article> findAll (){
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
    }

    public void deleteById(int id) {
        articles.removeIf(article -> article.getId() == id);
    }

    public void update(Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()) {
                articles.set(i, article);
                return;
            }
        }
    }








}
