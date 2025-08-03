package com.personalblog.persistence.dao;

import java.util.List;

public interface DAO<T> {

    List<T> findAll();

    T findById(int id);

    void save(T entity);

    void update(T entity);

    void deleteById(int id);

}
