package com.expeditors.dao;

import com.expeditors.domain.Track;

import java.util.List;

public interface BaseDAO<T> {

    T insert(T newObject);

    boolean delete(int id);

    boolean update(T updateObject);

    T findById(int id);

    List<T> findAll();

    default List<T> findByExample(T example) {
        throw new UnsupportedOperationException("Needs Implementing");
    }
}
