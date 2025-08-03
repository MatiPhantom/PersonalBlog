package com.personalblog.persistence.loader;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.personalblog.persistence.dao.ArticleDAO;
import com.personalblog.persistence.dao.UserDAO;
import com.personalblog.persistence.model.Article;
import com.personalblog.persistence.model.User;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void run(String... args) throws Exception {
        if (userDAO.findAll().size() == 0) {
            User user1 = new User("Matias", "Gutierrez", "matias.gutierrez@gmail.com", "123456");
            user1.setRole("ADMIN");
            userDAO.save(user1);
        }
        if (articleDAO.findAll().size() == 0) {
            Article article1 = new Article("Welcome to My Blog",
                    "This is the first article on my personal blog. Stay tuned for more updates!", LocalDate.now());

            articleDAO.save(article1);

        }
        System.out.println("DataLoader is running...");
    }

}
