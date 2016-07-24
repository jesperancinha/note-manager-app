package com.steelzack.titletextadder.api.dao;

public interface TitleDaoInterface<T> {

    void persist(T entity);

    void update(T entity);

    void delete(T entity);

}