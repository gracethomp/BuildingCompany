package com.solvd.dao;

public interface IBaseDAO<T> {
    T getByID(Long id);
    void update(T entity);
    T create(T entity);
    void remove(Long id);
}
