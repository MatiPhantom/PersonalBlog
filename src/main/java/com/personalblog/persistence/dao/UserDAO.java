package com.personalblog.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.personalblog.persistence.model.User;
import com.personalblog.persistence.storage.UtilUserStorage;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDAO implements DAO<User> {
    private final List<User> users = UtilUserStorage.load();

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User user) {
        log.info("Saving user: {}", user);
        users.add(user);
        UtilUserStorage.save(users);
    }

    public void deleteById(int id) {
        users.removeIf(article -> article.getId() == id);
        UtilUserStorage.save(users);
    }

    public void update(User user) {
        loop: for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break loop;
            }
        }
        UtilUserStorage.save(users);
    }
}
