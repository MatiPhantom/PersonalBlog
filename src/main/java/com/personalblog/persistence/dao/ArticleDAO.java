package com.personalblog.persistence.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.personalblog.persistence.model.Article;
import com.personalblog.persistence.storage.JsonStorage;

@Repository
public class ArticleDAO {

    private final List<Article> articles= JsonStorage.load();

    public List<Article> findAll (){
        return articles;
    }

    public Article findById(int id) {
        return articles.stream()
                       .filter(article -> article.getId() == id)
                       .findFirst()
                       .orElse(null);
    }

    public void setArticle(Article article) {
        articles.add(article);
        JsonStorage.save(articles);
    }

    public void deleteById(int id) {
        articles.removeIf(article -> article.getId() == id);
        JsonStorage.save(articles);
    }

    public void update(Article article) {
        loop: for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()) {
                articles.set(i, article);
                break loop;
            }
        }
        JsonStorage.save(articles);
    }








}
