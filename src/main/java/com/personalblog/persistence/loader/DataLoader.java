package com.personalblog.persistence.loader;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.personalblog.persistence.dao.ArticleDAO;
import com.personalblog.persistence.model.Article;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ArticleDAO articleDAO;

    @Override
    public void run(String... args) throws Exception {
        if (articleDAO.findAll().size() == 0) {
            Article article1 = Article.builder()
                    .title("Welcome to My Blog")
                    .content("This is the first article on my personal blog. Stay tuned for more updates!")
                    .publishedDate(LocalDate.now())
                    .build();
            articleDAO.setArticle(article1);
        }
        System.out.println("DataLoader is running...");
    }

}
